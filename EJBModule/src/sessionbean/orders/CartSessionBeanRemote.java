package sessionbean.orders;

import entity.orders.BookOrder;
import entity.orders.CartSaved;

import javax.ejb.Remote;

@Remote
public interface CartSessionBeanRemote {
    public int create();
    public void save(CartSaved cartSaved);
}
