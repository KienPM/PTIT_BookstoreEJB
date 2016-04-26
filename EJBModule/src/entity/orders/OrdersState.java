package entity.orders;

public interface OrdersState {

    public void doAction(Orders orders);

    public String toString();

}
