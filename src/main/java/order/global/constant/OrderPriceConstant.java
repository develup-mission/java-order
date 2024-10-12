package order.global.constant;

public enum OrderPriceConstant {

    MINIMUM_ORDER_PRICE(30000),
    DELIVER_PRICE_FIRST(2000),
    DELIVER_PRICE_SECOND(1000),
    DELIVER_PRICE_THIRD(0);

    private final int price;

    OrderPriceConstant(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
