package order.config;

import order.controller.OrderController;
import order.domain.OrderValidator;
import order.service.OrderMapper;
import order.service.OrderService;
import order.view.InputView;
import order.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static InputView inputView() {
        return new InputView();
    }

    public static OutputView outputView() {
        return new OutputView();
    }

    public static OrderMapper orderMapper() {
        return new OrderMapper();
    }

    public static OrderValidator orderValidator() {
        return new OrderValidator();
    }

    public static OrderService orderService() {
        return new OrderService(orderValidator(), orderMapper());
    }

    public static OrderController orderController() {
        return new OrderController(inputView(), outputView(), orderService());
    }
}
