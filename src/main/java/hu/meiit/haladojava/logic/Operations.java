package hu.meiit.haladojava.logic;

public enum Operations {
    ADDITION('+'), SUBTRACTION('-'), MULTIPLICATION('*'), DIVISION('/');

    private final char operator;

    Operations(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }
}
