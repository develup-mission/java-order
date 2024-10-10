package order.view;

import java.util.List;
import java.util.Map;
import order.service.OrderItemSummaryResponse;
import order.service.OrderResponse;
import order.service.OrderSummaryResponse;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printOrderSummary(OrderResponse response) {
        printOrderItemSummaries(response);
        printAdditionalService(response);
        printTotalPrice(response);
    }

    private void printOrderItemSummaries(OrderResponse response) {
        OrderSummaryResponse orderSummaryResponse = response.orderSummary();

        System.out.println();
        System.out.println("[주문 내역]");
        printOrderItemDetails(orderSummaryResponse);
        System.out.printf("총 주문 금액: %,d원%n", orderSummaryResponse.totalOrderPrice());
        System.out.printf("배달비: %,d원%n", orderSummaryResponse.deliveryFee());
    }

    private void printOrderItemDetails(OrderSummaryResponse orderSummaryResponse) {
        List<OrderItemSummaryResponse> orderItemSummaryResponses = orderSummaryResponse.orderItemSummaries();
        for (OrderItemSummaryResponse orderItemSummaryResponse : orderItemSummaryResponses) {
            System.out.printf("%s(%d개): %,d원%n",
                    orderItemSummaryResponse.menuName(),
                    orderItemSummaryResponse.amount(),
                    orderItemSummaryResponse.totalPrice());
        }
    }

    private void printAdditionalService(OrderResponse response) {
        Map<String, Integer> services = response.orderService().services();

        boolean noService = services.values().stream().noneMatch(count -> count > 0);
        if (noService) {
            return;
        }

        System.out.println();
        System.out.println("[서비스]");
        services.forEach((name, count) -> {
            if (count > 0) {
                System.out.printf("%s(%d개)%n", name, count);
            }
        });
    }

    private void printTotalPrice(OrderResponse response) {
        System.out.println();
        System.out.println("[최종 결제 금액]");
        System.out.printf("%,d원%n", response.totalPrice());
    }
}
