package order.controller;

import order.util.OrderMapper;
import order.view.InputView;
import order.view.OutputView;

import java.util.Map;

public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;

    public OrderController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String orderInput = inputView.getOrderInput();
        Map<String, Integer> orderMap = OrderMapper.parseOrder(orderInput);
        outputView.getOrderDetailsOutput(orderMap);
        outputView.getServiceOutput(orderMap);
        outputView.getFinalPaymentPriceOutput();
    }
}
