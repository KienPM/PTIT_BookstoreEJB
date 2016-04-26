package sessionbean.orders;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.orders.BookOrder;
import entity.orders.Cart;
import entity.orders.CartSaved;

/**
 * Session Bean implementation class CartSessionBean
 */
@Stateless
public class CartSessionBean implements CartSessionBeanRemote {
    @PersistenceContext(unitName = "BookstoreEJB")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public CartSessionBean() {
        // TODO Auto-generated constructor stub
    }

    public int create() {
        Cart cart = new Cart();
        em.persist(cart);
        return cart.getId();
    }

    @Override
    public void save(CartSaved cartSaved) {
        em.persist(cartSaved);
    }

}
