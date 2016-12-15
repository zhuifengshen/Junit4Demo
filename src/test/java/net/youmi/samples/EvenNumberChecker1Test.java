package net.youmi.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/6 16:31
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 *
 * http://junit.org/junit4/javadoc/latest/index.html
 */
@RunWith(Parameterized.class)
public class EvenNumberChecker1Test {

    //参数直接声明为public，则不需要构造器
    @Parameterized.Parameter(0)
    public int inputNumber;

    @Parameterized.Parameter(1)
    public boolean isEven;

    //也可直接返回数据数组
    @Parameterized.Parameters
    public static Object[][] data(){
        Object[][] data = new Object[][]{
                {2,true},
                {5,false},
                {7,false},
                {4,true}
        };
        return data;
    }

    @Test
    public void testEvenNumberChecker(){
        assertThat(isEven, is(new EvenNumberChecker().isEven(inputNumber)));
    }

}
