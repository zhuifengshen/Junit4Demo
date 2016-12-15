package net.youmi.samples;

/**
 * Created by Devin on 2016/9/20.
 */
public class Calculator {
    public int evaluate(String expression){
        int sum = 0;
        for (String summand : expression.split("\\+")) {
            sum += Integer.valueOf(summand);
        }
        return sum;
    }

    public double add(double a, double b){
        return a + b;
    }

    public double minus(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        int i = 0;
        while (true){
            i++;
        }
    }

    public double division(double a, double b){
        if (0.0 == b){
            throw new ArithmeticException("被除数不能为0");
        }else {
            return  a / b;
        }
    }
}
