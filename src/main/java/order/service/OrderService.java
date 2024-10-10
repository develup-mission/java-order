package order.service;

import order.domain.OrderLine;
import order.domain.OrderValidator;

public class OrderService {

    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    public OrderService(OrderValidator orderValidator, OrderMapper orderMapper) {
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    public OrderResponse order(OrderLineRequest request) {
        OrderLine orderLine = orderMapper.toOrderLine(request);

        orderValidator.validate(orderLine);

        int totalPrice = orderLine.getTotalPrice();
        int deliveryFee = calculateDeliveryFee(totalPrice);

        return orderMapper.toOrderResponse(orderLine, deliveryFee);
    }

    public int calculateDeliveryFee(int totalPrice) {
        if (totalPrice >= 100_000) {
            return 0;
        }
        if (totalPrice >= 50_000) {
            return 1_000;
        }
        return 2_000;
    }
}
