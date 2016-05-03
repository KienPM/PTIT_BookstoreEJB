package entity.orders;

/**
 * Created by Ken on 30/04/2016.
 */
public class CartSavedObserver extends Observer {
    public CartSavedObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {

    }
}
