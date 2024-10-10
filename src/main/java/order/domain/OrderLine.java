package order.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderLine {

    private static final String SERVICE_NAME = "서비스 만두";

    private final List<OrderItem> orderItems;

    public OrderLine(List<OrderItem> orderItems) {
        this.orderItems = new ArrayList<>(orderItems);
    }

    public Map<String, Integer> getAdditionalService() {
        List<OrderItem> mainItems = orderItems.stream()
                .filter(OrderItem::isMain)
                .toList();

        if (mainItems.isEmpty()) {
            return Map.of(SERVICE_NAME, 0);
        }

        int serviceCount = mainItems.stream()
                .mapToInt(OrderItem::getAmount)
                .sum();

        return Map.of(SERVICE_NAME, serviceCount);
    }

    public int getTotalPrice() {
        return orderItems.stream()
                .mapToInt(OrderItem::calculateTotalPrice)
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}
