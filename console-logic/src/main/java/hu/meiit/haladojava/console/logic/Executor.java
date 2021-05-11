package hu.meiit.haladojava.console.logic;

public class Executor {
    public double addition(int operand1, int operand2){
        return operand1+operand2;
    }
    public double subtract(int operand1, int operand2){
        return operand1-operand2;
    }
    public double multiply(int operand1, int operand2){
        return operand1*operand2;
    }
    public double divide(int operand1, int operand2){
        Double ret=null;
        try {
            ret = (double)operand1/(double)operand2;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}
