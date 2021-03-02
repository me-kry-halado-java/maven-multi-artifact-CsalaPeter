package hu.meiit.haladojava.calculator;

public class App
{
    public static void main( String[] args )
    {
        hu.meiit.haladojava.calculator.View view = new View();
        try {
            Expression expression = new Expression(view.readExpression());
            double result=expression.calculate();
            view.writeResult(result);

        }catch(Exception e) {
            view.writeMessage("-");
        }

    }
}
