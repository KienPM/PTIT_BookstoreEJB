package sessionbean.orders;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.orders.BookOrder;

/**
 * Session Bean implementation class BookOrderSessionBean
 */
@Stateless
public class BookOrderSessionBean implements BookOrderSessionBeanRemote {
	@PersistenceContext(unitName = "BookstoreEJB")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public BookOrderSessionBean() {
		// TODO Auto-generated constructor stub
	}

	public int saveBookOrder(BookOrder bookOrder) {
		em.persist(bookOrder);
		return bookOrder.getId();
	}

}
