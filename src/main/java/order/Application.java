package order;

import order.controller.OrderController;

public class Application {

    public static void main(String[] args) {
        OrderController game = new OrderController();
        game.run();
    }
}
