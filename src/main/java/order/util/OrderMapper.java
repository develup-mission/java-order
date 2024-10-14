package order.util;

import order.domain.Category;
import order.domain.Menu;
import order.validation.OrderValidator;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderMapper {

    public static Map<String, Integer> parseOrder(String orderInput) {
        Map<String, Integer> orderMap = new LinkedHashMap<>();
        int mainMenuCount = 0;
        int sideMenuCount = 0;
        int totalPrice = 0;

        String[] items = orderInput.split(",\\s*");

        for (String item : items) {
            String menu = item.replaceAll("\\(\\d+개\\)", "").trim();
            String quantityStr = item.replaceAll("[^\\d]", "");
            int quantity = Integer.parseInt(quantityStr);

            Menu menuEnum = findMenuByName(menu);

            if (menuEnum != null) {
                OrderValidator.validQuantity(quantity);

                mainMenuCount = getMainMenuCount(menuEnum, mainMenuCount, quantity);
                sideMenuCount = getSideMenuCount(menuEnum, sideMenuCount, quantity);

                totalPrice += menuEnum.getPrice() * quantity;

                orderMap.put(menu, quantity);
            }
        }

        OrderValidator.validOnlyDrink(mainMenuCount, sideMenuCount);
        OrderValidator.validMinimumOrderAmount(totalPrice);
        OrderValidator.validAddDumplings(mainMenuCount, orderMap);

        return orderMap;
    }

    private static int getMainMenuCount(Menu menuEnum, int mainMenuCount, int quantity) {
        if (menuEnum.getCategory().equals(Category.MAIN)) {
            mainMenuCount += quantity;
        }
        return mainMenuCount;
    }

    private static int getSideMenuCount(Menu menuEnum, int sideMenuCount, int quantity) {
        if (menuEnum.getCategory().equals(Category.SIDE)) {
            sideMenuCount += quantity;
        }
        return sideMenuCount;
    }

    private static Menu findMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }
}