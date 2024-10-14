package order.global.constant;

public enum OrderPriceConstant {

    MINIMUM_ORDER_PRICE(30000),
    DELIVERY_FEE_FIRST(2000),
    DELIVERY_FEE_SECOND(1000),
    DELIVERY_FEE_THIRD(0),
    DELIVERY_FEE_RANGE_FIRST(0),
    DELIVERY_FEE_RANGE_SECOND(50000),
    DELIVERY_FEE_RANGE_THIRD(100000);

    private final int price;

    OrderPriceConstant(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
