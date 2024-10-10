package order.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderValidator {

    public static final int MIN_ORDER_PRICE = 30_000;
    public static final int MAX_ORDER_AMOUNT = 10;

    public void validate(OrderLine orderLine) {
        validateOrderItemAmount(orderLine);
        validateMinOrderAmount(orderLine);
        validateNotOnlyDrink(orderLine);
    }

    private void validateOrderItemAmount(OrderLine orderLine) {
        boolean isValidOrderItemAmount = orderLine.getOrderItems().stream()
                .mapToInt(OrderItem::getAmount)
                .allMatch(amount -> amount <= MAX_ORDER_AMOUNT);

        if (!isValidOrderItemAmount) {
            throw new IllegalArgumentException("메뉴는 각각 10개 이하로 주문 가능합니다.");
        }
    }

    private void validateNotOnlyDrink(OrderLine orderLine) {
        Set<Category> categories = orderLine.getOrderItems().stream()
                .map(OrderItem::getCategory)
                .collect(Collectors.toSet());

        if (categories.size() == 1 && categories.contains(Category.DRINK)) {
            throw new IllegalArgumentException("음료만으로는 주문할 수 없습니다.");
        }
    }

    private void validateMinOrderAmount(OrderLine orderLine) {
        if (orderLine.getTotalPrice() < MIN_ORDER_PRICE) {
            throw new IllegalArgumentException("최소 주문 금액을 만족하지 못했습니다.");
        }
    }
}
