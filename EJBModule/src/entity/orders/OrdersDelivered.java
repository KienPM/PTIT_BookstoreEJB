package entity.orders;

public class OrdersDelivered implements OrdersState {
	@Override
	public void doAction(Orders orders) {

	}
	
	@Override
	public String toString() {
		return "Đã phân phối";
	}
}
