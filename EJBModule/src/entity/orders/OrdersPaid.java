package entity.orders;

public class OrdersPaid implements OrdersState {
	@Override
	public void doAction(Orders orders) {
	}

	@Override
	public String toString() {
		return "Đã thanh toán";
	}
}
