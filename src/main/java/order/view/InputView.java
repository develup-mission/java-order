package order.view;

import order.view.message.OrderMessage;

import java.util.Scanner;

public class InputView {

    public String getOrderInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println(OrderMessage.ORDER_INPUT.getMessage());

        return sc.nextLine();
    }
}
