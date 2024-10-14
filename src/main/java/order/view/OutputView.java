package order.view;

import order.service.OrderService;
import order.validation.DeliverCostValidator;
import order.view.message.OrderMessage;

import java.util.Map;

public class OutputView {

    private final DeliverCostValidator deliverCostValidator;

    public OutputView() {
        this.deliverCostValidator = new DeliverCostValidator();
    }

    public void getOrderDetailsOutput(Map<String, Integer> orderMap) {
        System.out.println(OrderMessage.ORDER_DETAILS.getMessage());
        OrderService.printOrderWithPrice(orderMap, deliverCostValidator);
    }

    public void getServiceOutput(Map<String, Integer> orderMap) {
        if (OrderService.hasServiceDumpling(orderMap)) {
            System.out.println(OrderMessage.SERVICE.getMessage());
            OrderService.printServiceDumplings(orderMap);
        }
    }

    public void getFinalPaymentPriceOutput() {
        System.out.println(OrderMessage.FINAL_PAYMENT_PRICE.getMessage());
        OrderService.printFinalPaymentPrice();
    }
}