package sessionbean.orders;

import entity.orders.BookOrder;

import javax.ejb.Remote;

@Remote
public interface CartSessionBeanRemote {
    public int create();
}
