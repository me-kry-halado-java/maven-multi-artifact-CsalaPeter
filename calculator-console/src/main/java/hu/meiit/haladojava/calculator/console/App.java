package hu.meiit.haladojava.calculator.console;

import hu.meiit.haladojava.console.logic.Executor;
import hu.meiit.haladojava.console.logic.Expressions;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final String errorResponse = "-";

    private static String[] parse(String expression) {
        if (expression.contains(" ")) {
            return expression.split(" ");
        }
        char sub;
        ArrayList<String> express = new ArrayList<>();
        String[] other;
        String[] retValue = new String[3];
        int index = 0;
        if (expression.contains("+")) {
            index = expression.indexOf("+");
        } else if (expression.contains("-")) {
            index = expression.indexOf("-");
        } else if (expression.contains("*")) {
            index = expression.indexOf("*");
        } else if (expression.contains("/")) {
            index = expression.indexOf("/");
        }
        sub = expression.charAt(index);

        other = expression.split("[+ - * /]");
        express.add(other[0]);
        express.add(String.valueOf(sub));
        express.add(other[1]);
        for (int i = 0; i < express.size(); i++) {
            retValue[i] = express.get(i);
        }
        return retValue;
    }

    private static String getExpressionFromStandardInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void assertExpression(String[] parts) {
        if (parts.length != 3) {
            throw new RuntimeException("wrong input");
        }
    }

    private static Expressions getAsExpression(String[] parts) {
        return new Expressions(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[2]), parts[1]);
    }

    private static String executeExpression(Expressions expression) {
        String result = errorResponse;
        Executor executor = new Executor();
        String switcher = expression.getOperator();
        switch (switcher) {
            case "+":
                result = String.valueOf(executor.addition(expression.getOperand1()
                        , expression.getOperand2()));
                break;
            case "-":
                result = String.valueOf(executor.subtract(expression.getOperand1()
                        , expression.getOperand2()));
                break;
            case "*":
                result = String.valueOf(executor.multiply(expression.getOperand1()
                        , expression.getOperand2()));
                break;
            case "/":
                result = String.valueOf(executor.divide(expression.getOperand1()
                        , expression.getOperand2()));
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String result = "-";
        try {

            String expressionFromStandardInput = getExpressionFromStandardInput();
            String[] parts = parse(expressionFromStandardInput);
            assertExpression(parts);
            Expressions expressions = getAsExpression(parts);
            result = executeExpression(expressions);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(result);
    }
}
