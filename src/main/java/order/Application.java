package order;

import order.config.AppConfig;
import order.controller.OrderController;

public class Application {

    public static void main(String[] args) {
        OrderController orderController = AppConfig.orderController();
        orderController.run();
    }
}
