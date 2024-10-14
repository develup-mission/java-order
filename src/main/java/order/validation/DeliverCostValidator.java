package order.validation;

import java.util.NavigableMap;
import java.util.TreeMap;

import static order.global.constant.OrderPriceConstant.*;

public class DeliverCostValidator {

    private static final NavigableMap<Integer, Integer> DELIVERY_FEE_RULES = new TreeMap<>();

    static {
        DELIVERY_FEE_RULES.put(DELIVERY_FEE_RANGE_FIRST.getPrice(), DELIVERY_FEE_FIRST.getPrice());
        DELIVERY_FEE_RULES.put(DELIVERY_FEE_RANGE_SECOND.getPrice(), DELIVERY_FEE_SECOND.getPrice());
        DELIVERY_FEE_RULES.put(DELIVERY_FEE_RANGE_THIRD.getPrice(), DELIVERY_FEE_THIRD.getPrice());
    }

    public int getDeliveryFee(int totalPrice) {
        return DELIVERY_FEE_RULES.floorEntry(totalPrice)
                .getValue();
    }
}