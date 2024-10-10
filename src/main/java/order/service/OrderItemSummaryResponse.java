package order.service;

public record OrderItemSummaryResponse(String menuName, int amount, int totalPrice) {
}
