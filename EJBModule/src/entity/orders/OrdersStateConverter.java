package entity.orders;

import javax.persistence.AttributeConverter;

/**
 * Created by Ken on 26/04/2016.
 */
public class OrdersStateConverter implements AttributeConverter<OrdersState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrdersState ordersState) {
        return ordersState.toInt();
    }

    @Override
    public OrdersState convertToEntityAttribute(Integer state) {
        if (state == 1) {
            return new OrdersWaitConfirm();
        }
        if (state == 2) {
            return new OrdersDelivered();
        }
        return new OrdersPaid();
    }
}
