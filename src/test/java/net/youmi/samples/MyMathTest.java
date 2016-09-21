package net.youmi.samples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.fail;

/**
 * Created by Devin on 2016/9/20.
 */
public class MyMathTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void factorial() throws Exception {
        new MyMath().factorial(1);
    }

    @Test(expected = Exception.class) //测试异常
    public void testFactorial() throws Exception{
        new MyMath().factorial(-1);
        fail("factorial参数为负数没有抛出异常");
    }

    @Test
    public void fibonacci() throws Exception {
        new MyMath().fibonacci(1);
    }

    @Test(timeout = 10000) //测试超时
    public void bubbleSort() throws Exception {
        int[] array = new int[10000];
        int length = array.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        new MyMath().bubbleSort(array);
    }

    @Test(timeout = 1000)
    public void quickSort() throws Exception {
        int[] array = new int[100000];
        int length = array.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        new MyMath().quickSort(array);
    }
}