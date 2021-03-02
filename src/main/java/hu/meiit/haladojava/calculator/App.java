package hu.meiit.haladojava.calculator;

import hu.meiit.haladojava.logic.CalcException;
import hu.meiit.haladojava.logic.Executor;
import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.logic.IExecutor;
import java.util.Scanner;

public class App
{

    private static String getExpressionFromStandardInput() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        return expression;
    }

    public static void main( String[] args )
    {
        try {
            String strExpression = getExpressionFromStandardInput();
            Expression expression = Expressions.parse(strExpression);
            IExecutor executor = new Executor();
            System.out.print(executor.executeExpression(expression));
        }
        catch (InvalidInputException e) {
            System.out.println("-");
        }
        catch (CalcException e) {
            System.out.println("-");
        }
    }
}