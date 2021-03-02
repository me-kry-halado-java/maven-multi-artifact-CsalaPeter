package hu.meiit.haladojava.calculator;


public class Calc {

    private Calc(){
        super();
    }


    public static double add(int a, int b){
        return (double)a+b;
    }

    public static double substraction(int a, int b){
        return (double)a-b;
    }

    public static double multiply(int a, int b){
        return (double)a*b;
    }

    public static double divide(int a, int b) throws ArithmeticException{
        if (b==0) throw new ArithmeticException();
        return (double)a/b;
    }
}