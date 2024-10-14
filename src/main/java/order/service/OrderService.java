package order.service;

import order.domain.Category;
import order.domain.Menu;
import order.validation.DeliverCostValidator;
import order.view.message.OrderMessage;

import java.util.Map;

public class OrderService {

    static int totalPrice = 0;

    public static void printOrderWithPrice(Map<String, Integer> orderMap, DeliverCostValidator deliverCostValidator) {

        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();

            Menu menu = findMenuByName(menuName);

            if (menu != null && !menu.getCategory().equals(Category.SERVICE)) {
                int itemTotalPrice = menu.getPrice() * quantity;
                totalPrice += itemTotalPrice;
                System.out.println(menu.getName() + "(" + quantity + "개): " + formatPrice(itemTotalPrice) + "원");
            }
        }

        System.out.println(OrderMessage.TOTAL_PRICE_PREFIX + formatPrice(totalPrice) + "원");

        int deliveryFee = deliverCostValidator.getDeliveryFee(totalPrice);
        totalPrice += deliveryFee;

        System.out.println(OrderMessage.DELIVERY_FEE_PREFIX + formatPrice(deliveryFee) + "원");
    }

    private static Menu findMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }

    public static void printServiceDumplings(Map<String, Integer> orderMap) {
        int quantity = orderMap.get(Menu.SERVICE_DUMPLING.getName());
        System.out.println(Menu.SERVICE_DUMPLING.getName() + "(" + quantity + "개)");
    }

    public static boolean hasServiceDumpling(Map<String, Integer> orderMap) {
        return orderMap.containsKey(Menu.SERVICE_DUMPLING.getName());
    }

    public static void printFinalPaymentPrice() {
        System.out.println(formatPrice(totalPrice) + "원");
    }

    private static String formatPrice(int price) {
        return String.format("%,d", price);
    }
}