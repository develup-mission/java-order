package order.domain;

public class OrderItem {

    private final Menu menu;
    private final int amount;

    public OrderItem(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int calculateTotalPrice() {
        return menu.getPrice() * amount;
    }

    public Category getCategory() {
        return menu.getCategory();
    }

    public boolean isMain() {
        return menu.getCategory() == Category.MAIN;
    }

    public int getAmount() {
        return amount;
    }
}
