package order.validation;

public class OrderInputValidator {

    public final String ORDER_MENU_SPLIT = ", ";
    public final String ORDER_REGEX = "([가-힣a-zA-Z]+)\\((\\d+)개\\)";
    public final int MAX_MENU_QUANTITY = 10;
}
