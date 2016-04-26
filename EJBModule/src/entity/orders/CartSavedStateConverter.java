package entity.orders;

import javax.persistence.AttributeConverter;

/**
 * Created by Ken on 26/04/2016.
 */
public class CartSavedStateConverter implements AttributeConverter<CartSavedState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CartSavedState cartSavedState) {
        return cartSavedState.toInt();
    }

    @Override
    public CartSavedState convertToEntityAttribute(Integer state) {
        if (state == 1) {
            return new CartSavedNotOrdered();
        }
        return new CartSavedOrdered();
    }
}
