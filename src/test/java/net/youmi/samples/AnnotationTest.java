package net.youmi.samples;

import org.junit.*;

/**
 * Created by Devin on 2016/9/20.
     单元测试规范:
     1.单元测试类后面加Test
     2.测试方法使用@Test标注
     3.测试方法名之前加test
     4.所有测试方法返回类型必须为void且无参数
     5.每个测试方法之间相互独立;

    常用注解:
     @Test：把一个方法标记为测试方法
     两个属性:
     excepted属性是用来测试异常;
     timeout用来测试性能的，就是测试一个方法能不能在规定时间内完成;
     也可使用Timeout规则来测试类中的所有方法。如果类中的任意一个方法执行时间超过了在Timeout 规则中规定的值，测试方法将抛出异常，测试结果为失败。指定的超时参数是以毫秒记。如:
        @Rule
        public Timeout timeout = new Timeout(1000);
     @Before：每一个测试方法执行前自动调用一次
     @After：每一个测试方法执行完自动调用一次
     @BeforeClass：所有测试方法执行前执行一次，在测试类还没有实例化就已经被加载，所以用static修饰
     @AfterClass：所有测试方法执行完执行一次，在测试类还没有实例化就已经被加载，所以用static修饰
     @Ignore：禁止执行junit测试类的某些或者全部测试方法,应用在方法或类上

    常用方法:
     idea IDE自动生成单元测试类快捷键 Ctrl+Shift+T
     新增单元测试方法快捷键 Alt+Insert

     assertNull(java.lang.Object object) 	检查对象是否为空
     assertNotNull(java.lang.Object object) 	检查对象是否不为空
     assertEquals(long expected, long actual) 	检查long类型的值是否相等
     assertEquals(double expected, double actual, double delta) 	检查指定精度的double值是否相等
     assertFalse(boolean condition) 	检查条件是否为假
     assertTrue(boolean condition) 	检查条件是否为真
     assertSame(java.lang.Object expected, java.lang.Object actual) 	检查两个对象引用是否引用同一对象（即对象是否相等）
     assertNotSame(java.lang.Object unexpected, java.lang.Object actual)    检查两个对象引用是否不引用统一对象(即对象不等)
     fail(String string)  在没有报告的情况下使测试不通过
 */
public class AnnotationTest {

    int i;

    public AnnotationTest(){
        System.out.println("构造方法");
    }

    /**
     * java.lang.Exception: Method setUpBeforClass() should be static
     */
    @BeforeClass
    public static void setUpBeforClass(){
        System.out.println("BeforClass");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        System.out.println("AfterClass");
    }

    @Before
    public void setUp(){
        System.out.println("Before");
    }

    @After
    public void tearDown(){
        System.out.println("After");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
        System.out.println("i="+ i++);
    }

    @Test
    public void test2(){
        System.out.println("Test2");
        System.out.println("i="+ i++);
    }

    @Ignore
    public void test3(){
        System.out.println("Test3");
    }
}
