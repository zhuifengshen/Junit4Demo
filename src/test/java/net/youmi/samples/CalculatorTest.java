package net.youmi.samples;

import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Devin on 2016/9/20.
 *
 *
 * http://junit.org/junit4/javadoc/latest/index.html
 */
public class CalculatorTest {
    //定义测试用例分类
    public interface SmokeTests{}
    public interface SlowTests{}

    Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        System.out.println("AfterClass");
    }

    public CalculatorTest(){
        System.out.println("无参构造函数");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before");
        //初始化
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After");
        calculator = null;
    }
    //同时指定多个分类，分类可以标注在方法上或者类上
    @Category({SmokeTests.class, SlowTests.class})
    @Test
    public void evaluate() throws Exception {
        System.out.println("evaluate()");
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }

    @Category(SmokeTests.class)
    @Test
    public void testAdd1(){
        System.out.println("testAdd1()");
        assertThat(3.64, is(calculator.add(3.14, 0.5)));
    }

    @Category(SlowTests.class)
    @Test
    public void testAdd2() throws Exception{
        Thread.sleep(1000);
        System.out.println("testAdd2()");
        assertThat(2003.14, is(calculator.add(3.14, 2000)));
    }

    @Category(SlowTests.class)
    @Test
    public void testAdd3() throws Exception{
        Thread.sleep(2000);
        System.out.println("testAdd3()");
        assertThat(100.0, is(calculator.add(99.0, 1.0)));
    }

    @Ignore
    @Test
    public void testMinus(){
        System.out.println("testMinus()");
        assertThat(0.0, is(calculator.minus(3.14, 3.14)));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivision(){
        System.out.println("testDivision()");
        calculator.division(3.14, 0.0);
    }

    @Ignore
    @Test(timeout = 1000)
    public void testMultiply(){
        assertThat(3.14, is(calculator.multiply(3.14, 1.0)));
    }
}