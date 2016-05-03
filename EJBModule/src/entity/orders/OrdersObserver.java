package entity.orders;

/**
 * Created by Ken on 30/04/2016.
 */
public class OrdersObserver extends Observer {
    public OrdersObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {

    }
}
