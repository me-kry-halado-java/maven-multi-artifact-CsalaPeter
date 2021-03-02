package hu.meiit.haladojava.calculator;

import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.logic.Operations;

public class Expressions {

    public static final char[] acceptedOperations = new char[] {'+', '-', '*', '/'};

    private Expressions(){
        super();
    }

    public static Expression parse(String expression) throws InvalidInputException {
        String[] tokens = expression.split(" ");
        double[] numericTokens;
        char operator;
        if (tokens.length != 3) {
            tokens = splitByOperator(expression);
            try{
                numericTokens = getNumericTokens(tokens);
            }
            catch (NumberFormatException e) {
                throw new InvalidInputException();
            }
        }
        else {
            numericTokens = getNumericTokens(tokens);
        }
        operator = getOperator(expression);
        return new Expression(numericTokens[0], numericTokens[1], convertOperatorToOperation(operator));
    }

    private static String[] splitByOperator(String expression) {
        return expression.split("[\\+\\-\\*\\/]");
    }

    private static double[] getNumericTokens(String[] tokens) throws InvalidInputException{
        double operand1;
        double operand2;
        if (tokens.length == 2) {
            operand1 = Double.parseDouble(tokens[0]);
            operand2 = Double.parseDouble(tokens[1]);
        }
        else if (tokens.length == 3) {
            operand1 = Double.parseDouble(tokens[0]);
            operand2 = Double.parseDouble(tokens[2]);
        }
        else {
            throw new InvalidInputException();
        }
        return new double[]{operand1, operand2};
    }

    private static char getOperator(String expression) throws InvalidInputException {
        char operator = 'Đ';
        for(char searchedOperator : acceptedOperations) {
            int position = expression.indexOf(searchedOperator);
            if(position > 0) {
                operator = searchedOperator;
            }
        }
        if(operator == 'Đ') {
            throw new InvalidInputException();
        }
        else {
            return operator;
        }
    }

    private static Operations convertOperatorToOperation(char operator) throws InvalidInputException{
        switch (operator) {
            case '+':
                return Operations.ADDITION;
            case '-':
                return Operations.SUBTRACTION;
            case '*':
                return Operations.MULTIPLICATION;
            case '/':
                return Operations.DIVISION;
            default:
                throw new InvalidInputException();
        }
    }

}