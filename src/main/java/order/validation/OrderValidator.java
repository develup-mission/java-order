package order.validation;

import order.domain.Menu;
import order.exception.OrderException;
import order.exception.message.ErrorMessage;
import order.global.constant.OrderPriceConstant;

import java.util.Map;

public class OrderValidator {

    public static void validQuantity(int quantity) {
        if (quantity < 0 || quantity > 10) {
            throw new OrderException(ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.ERROR_ORDER_RANGE.getMessage());
        }
    }

    public static void validOnlyDrink(int mainMenuCount, int sideMenuCount) {
        if (mainMenuCount == 0 && sideMenuCount == 0) {
            throw new OrderException(ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.ERROR_ORDER_ONLY_DRINK.getMessage());
        }
    }

    public static void validAddDumplings(int mainMenuCount, Map<String, Integer> orderMap) {
        if (mainMenuCount > 0) {
            orderMap.put(Menu.SERVICE_DUMPLING.getName(), mainMenuCount);
        }
    }

    public static void validMinimumOrderAmount(int totalPrice) {
        if (totalPrice < OrderPriceConstant.MINIMUM_ORDER_PRICE.getPrice()) {
            throw new OrderException(ErrorMessage.ERROR_PREFIX.getMessage() + ErrorMessage.ERROR_MINIMUM_ORDER_AMOUNT.getMessage());
        }
    }
}