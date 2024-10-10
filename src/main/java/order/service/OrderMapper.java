package order.service;

import java.util.List;
import java.util.Map;
import order.domain.Menu;
import order.domain.OrderItem;
import order.domain.OrderLine;

public class OrderMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        List<OrderItemRequest> orderItemRequests = orderLineRequest.orderItems();
        List<OrderItem> orderItems = orderItemRequests.stream()
                .map(this::toOrderItem)
                .toList();

        return new OrderLine(orderItems);
    }

    private OrderItem toOrderItem(OrderItemRequest orderItemRequest) {
        Menu menu = Menu.from(orderItemRequest.menuName());
        if (orderItemRequest.amount() < 1) {
            throw new IllegalArgumentException("주문 수량은 1개 이상이어야 합니다.");
        }

        return new OrderItem(menu, orderItemRequest.amount());
    }

    public OrderResponse toOrderResponse(OrderLine orderLine, int deliveryFee) {
        OrderSummaryResponse orderSummaryResponse = toOrderSummaryResponse(orderLine, deliveryFee);
        OrderServiceResponse orderServiceResponse = toOrderServiceResponse(orderLine.getAdditionalService());
        int totalPrice = orderLine.getTotalPrice() + deliveryFee;

        return new OrderResponse(orderSummaryResponse, orderServiceResponse, totalPrice);
    }

    private OrderSummaryResponse toOrderSummaryResponse(OrderLine orderLine, int deliveryFee) {
        List<OrderItemSummaryResponse> orderItemSummaryResponses = orderLine.getOrderItems().stream()
                .map(this::toOrderItemSummaryResponse)
                .toList();

        int totalOrderPrice = orderLine.getTotalPrice();

        return new OrderSummaryResponse(orderItemSummaryResponses, totalOrderPrice, deliveryFee);
    }

    private OrderItemSummaryResponse toOrderItemSummaryResponse(OrderItem orderItem) {
        String menuName = orderItem.getMenuName();
        int amount = orderItem.getAmount();
        int totalPrice = orderItem.calculateTotalPrice();

        return new OrderItemSummaryResponse(menuName, amount, totalPrice);
    }

    private OrderServiceResponse toOrderServiceResponse(Map<String, Integer> service) {
        return new OrderServiceResponse(service);
    }
}
