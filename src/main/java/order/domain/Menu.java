package order.domain;

import java.util.Arrays;

public enum Menu {

    PIZZA(Category.MAIN, "피자", 25_000),
    HAMBURGER(Category.MAIN, "햄버거", 10_000),
    CHICKEN(Category.MAIN, "치킨", 23_000),

    FRENCH_FRIES(Category.SIDE, "감자튀김", 5000),
    CHEESE_STICKS(Category.SIDE, "치즈스틱", 7000),
    SALAD(Category.SIDE, "샐러드", 8000),

    COLA(Category.DRINK, "콜라", 2000),
    ZERO_COLA(Category.DRINK, "제로 콜라", 2500),
    ORANGE_JUICE(Category.DRINK, "오렌지 주스", 3000),
    ;

    private final Category category;
    private final String name;
    private final int price;

    Menu(Category category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static Menu from(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
