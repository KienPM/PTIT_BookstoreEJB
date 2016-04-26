package entity.orders;

/**
 * Created by Ken on 26/04/2016.
 */
public class CartSavedNotOrdered implements CartSavedState {
    @Override
    public void doAction() {

    }

    @Override
    public int toInt() {
        return 2;
    }
}
