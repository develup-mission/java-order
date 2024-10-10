package order.service;

import java.util.List;

public record OrderSummaryResponse(
        List<OrderItemSummaryResponse> orderItemSummaries,
        int totalOrderPrice,
        int deliveryFee
) {
}
