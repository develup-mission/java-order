package order.exception.message;

public enum ErrorMessage {

    ERROR_PREFIX("\n[ERROR]: "),
    ERROR_DELIVERY_FEE("배송비를 확인할 수 없습니다."),
    ERROR_ORDER_RANGE("메뉴는 각각 최소 0개 ~ 최대 10개까지 주문할 수 있습니다."),
    ERROR_ORDER_ONLY_DRINK("음료만으로는 주문할 수 없습니다."),
    ERROR_MINIMUM_ORDER_AMOUNT("최소 주문 금액을 만족하지 못했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
