package net.youmi.samples;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/6 16:24
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 *
 * Runner: Theories 通过@DataPoint（单个），@DataPoints（数组）指定数据集；@Theory指定测试方法，该方法带形参，获取前面@DataPoint或@DataPoints指定的数据。适合使用大量数据，进行测试
 */
@RunWith(Theories.class)
public class TheoriesTest {
    /**
     * java.lang.Error: DataPoint field num1 must be static
     */
    @DataPoint
    public static int num1 = 2;

    @DataPoint
    public static int num2 = 3;

    @DataPoints
    public static int[] num3 = {4, 5, 6, 7, 8};

    @Theory
    public void testNum(int num){
        System.out.println("测试数据：" + num);
        assertThat(num, greaterThan(1));
        //assertThat(num, lessThan(8));
    }
}
