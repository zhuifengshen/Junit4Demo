package net.youmi.util;

import net.youmi.samples.CalculatorTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/6 17:53
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class RetryFailCaseTest {
    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new MyFailListener());
        Result result = jUnitCore.run(CalculatorTest.class);
    }
}
