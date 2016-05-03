package entity.orders;

/**
 * Created by Ken on 26/04/2016.
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
