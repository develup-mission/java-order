package order.view.message;

public enum OrderMessage {

    ORDER_INPUT("주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)"),
    ORDER_DETAILS("\n[주문 내역]"),
    SERVICE("\n[서비스]"),
    FINAL_PAYMENT_PRICE("\n[최종 결제 금액]"),
    TOTAL_PRICE_PREFIX("총 주문 금액: "),
    DELIVERY_FEE_PREFIX("배달비: ");


    private final String message;

    OrderMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
