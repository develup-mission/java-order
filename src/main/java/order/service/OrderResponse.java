package order.service;

public record OrderResponse(
        OrderSummaryResponse orderSummary,
        OrderServiceResponse orderService,
        int totalPrice
) {
}
