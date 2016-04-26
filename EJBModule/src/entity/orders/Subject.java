package entity.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken on 26/04/2016.
 */
public abstract class Subject {
    protected List<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }


}
