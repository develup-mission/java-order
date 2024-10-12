package order.view.message;

public enum OrderMessage {

    ORDER_INPUT("주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)\n"),
    ORDER_DETAILS("[주문 내역]\n"),
    SERVICE("[서비스]\n"),
    FINAL_PAYMENT_PRICE("[최종 결제 금액]\n");


    private final String message;

    OrderMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
