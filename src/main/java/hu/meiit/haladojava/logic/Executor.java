package hu.meiit.haladojava.logic;

public class Executor implements IExecutor{

    @Override
    public double executeExpression(Expression expression) throws CalcException {
        switch (expression.getOperation()) {
            case ADDITION:
                return expression.getOperand1() + expression.getOperand2();
            case SUBTRACTION:
                return expression.getOperand1() - expression.getOperand2();
            case MULTIPLICATION:
                return expression.getOperand1() * expression.getOperand2();
            case DIVISION:
                if (expression.getOperand2() == 0) {
                    throw new CalcException();
                }
                return expression.getOperand1() / expression.getOperand2();
            default:
                throw new CalcException();
        }
    }
}
