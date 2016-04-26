package entity.orders;

public class OrdersWaitConfirm implements OrdersState {
    @Override
    public void doAction(Orders orders) {
    }
    
    @Override
	public String toString() {
		return "Đang chờ xác nhận";
	}

    @Override
    public int toInt() {
        return 1;
    }
}
