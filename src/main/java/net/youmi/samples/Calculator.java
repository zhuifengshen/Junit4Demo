package net.youmi.samples;

/**
 * Created by Devin on 2016/9/20.
 */
public class Calculator {
    public int evaluate(String expression){
        int sum = 0;
        for (String summand : expression.split("\\+")) {
            System.out.println(summand);
            sum += Integer.valueOf(summand);
        }
        return sum;
    }

    public int add(int a, int b){
        return a + b;
    }
}
