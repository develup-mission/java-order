package order.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import order.service.OrderItemRequest;
import order.service.OrderLineRequest;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public OrderLineRequest readOrderLine() {
        System.out.println("주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)");
        String orderLineString = SCANNER.nextLine();

        try {
            return mapToOrderLineRequest(orderLineString);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("주문 형식이 잘못되었습니다.", e);
        }
    }

    private OrderLineRequest mapToOrderLineRequest(String orderLineString) {
        List<String> menuAmountStrings = Arrays.stream(orderLineString.split(",", -1))
                .map(String::trim)
                .toList();

        if (menuAmountStrings.isEmpty()) {
            throw new IllegalArgumentException("주문할 메뉴가 없습니다.");
        }

        List<OrderItemRequest> orderItemRequests = menuAmountStrings.stream()
                .map(this::mapToOrderItemRequest)
                .toList();

        return new OrderLineRequest(orderItemRequests);
    }

    private OrderItemRequest mapToOrderItemRequest(String menuAmountString) {
        int indexOfOpenBracket = menuAmountString.indexOf("(");
        int indexOfCloseBracket = menuAmountString.indexOf(")");

        if (indexOfOpenBracket == -1 || indexOfCloseBracket == -1) {
            throw new IllegalArgumentException("주문 형식이 잘못되었습니다.");
        }

        String menuName = menuAmountString.substring(0, indexOfOpenBracket);
        String amountString = menuAmountString.substring(indexOfOpenBracket + 1, indexOfCloseBracket - 1);
        int amount = parseToInt(amountString, "주문 수량은 숫자로 입력해주세요.");

        return new OrderItemRequest(menuName, amount);
    }

    private int parseToInt(String target, String errorMessage) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
