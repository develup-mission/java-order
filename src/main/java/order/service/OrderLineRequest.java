package order.service;

import java.util.List;

public record OrderLineRequest(List<OrderItemRequest> orderItems) {
}
