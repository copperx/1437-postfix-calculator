import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a postfix expression: ");
        String input = scanner.nextLine();

        IntStack s = new IntStack();
        String[] parts = input.trim().split("\\s+");

        for (String part : parts) {
            if (isOperator(part)) {
                if (s.isEmpty()) {
                    System.out.println("Missing number");
                    return;
                }
                double value2 = s.pop();

                if (s.isEmpty()) {
                    System.out.println("Missing number");
                    return;
                }
                double value1 = s.pop();

                if (part.equals("+")) {
                    s.push(value1 + value2);
                } else if (part.equals("-")) {
                    s.push(value1 - value2);
                } else if (part.equals("*")) {
                    s.push(value1 * value2);
                } else if (part.equals("/")) {
                    s.push(value1 / value2);
                } else if (part.equals("^")) {
                    s.push(Math.pow(value1, value2));
                }
            } else {
                s.push(Double.parseDouble(part));
            }
        }

        if (s.isEmpty()) {
            System.out.println("Missing number");
            return;
        }

        double result = s.pop();
        if (!s.isEmpty()) {
            System.out.println("Missing operator");
            return;
        }

        System.out.println(result);
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
}
