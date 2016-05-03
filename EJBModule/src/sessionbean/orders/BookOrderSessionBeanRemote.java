package sessionbean.orders;

import javax.ejb.Remote;

import entity.orders.BookOrder;

@Remote
public interface BookOrderSessionBeanRemote {
	public int saveBookOrder(BookOrder bookOrder);
	public void changeState(BookOrder bookOrder);
}
