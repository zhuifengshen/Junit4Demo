package net.youmi.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/21 10:48
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 *
 Junit 4 参数化测试 允许通过变化范围的参数值来测试方法。参数化测试可以通过以下简单的步骤实现：
 1.对测试类添加注解 @RunWith(Parameterized.class)
 2.将需要使用变化范围参数值测试的参数定义为私有变量
 3.使用上一步骤声明的私有变量作为入参，创建构造函数
 4.创建一个使用@Parameters注解的公共静态方法，它将需要测试的各种变量值通过集合的形式返回。
 5.使用定义的私有变量定义测试方法
 */
@RunWith(Parameterized.class)
public class EvenNumberCheckerTest {
    private int inputNumber;
    private boolean isEven;

    public EvenNumberCheckerTest(int inputNumber, boolean isEven){
        this.inputNumber = inputNumber;
        this.isEven = isEven;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {2,true},
                {5,false},
                {7,false},
                {4,true}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testEvenNumberChecker(){
        System.out.println("inputNumber:" + inputNumber + " isEven:" + isEven);
        EvenNumberChecker evenNumberChecker = new EvenNumberChecker();
        boolean result = evenNumberChecker.isEven(inputNumber);
        assertEquals(isEven, result);
    }
}