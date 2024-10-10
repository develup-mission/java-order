package order.controller;

import order.service.OrderLineRequest;
import order.service.OrderResponse;
import order.service.OrderService;
import order.view.InputView;
import order.view.OutputView;

public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;

    public OrderController(InputView inputView, OutputView outputView, OrderService orderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        try {
            OrderLineRequest orderLineRequest = inputView.readOrderLine();
            OrderResponse orderResponse = orderService.order(orderLineRequest);

            outputView.printOrderSummary(orderResponse);
        } catch (RuntimeException ex) {
            outputView.printErrorMessage(ex.getMessage());
        }
    }
}
