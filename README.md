## JUnit4.12 入门实践

### 内容概要：

* 为什么要做单元测试

* JUnit简介

* 单元测试规范

* JUnit4常用注解

* JUnit4异常和超时测试

* JUnit4常用断言方法

* JUnit4参数化测试

* JUnit4测试套件

附：[源码Github地址](https://github.com/zhuifengshen/Junit4Demo)

源码工程基于Idea IDE创建，其对JUnit对支持非常不错，写单元测试类也非常方便，直接使用快捷键Ctrl+Shift+T即可自动生成相应的单元测试类模板，使用快捷键Alt+Insert可直接添加新增的单元测试方法；项目使用Gradle进行依赖管理。

### 为什么做单元测试：

* **1.帮助理解需求**

单元测试应该反映Use Case，把被测单元当成黑盒测试其外部行为。

* **2.提高实现质量**

单元测试不保证程序做正确的事，但能帮助保证程序正确地做事，从而提高实现质量。

* **3.测试成本低**

相比集成测试、验收测试，单元测试所依赖的外部环境少，自动化程度高，时间短，节约了测试成本。

* **4.反馈速度快**

单元测试提供快速反馈，把bug消灭在开发阶段，减少问题流到集成测试、验收测试和用户，降低了软件质量控制的成本。

* **5.利于重构**

由于有单元测试作为回归测试用例，有助于预防在重构过程中引入bug。

* **6.文档作用**

单元测试提供了被测单元的使用场景，起到了使用文档的作用。

* **7.对设计的反馈**

一个模块很难进行单元测试通常是不良设计的信号，单元测试可以反过来指导设计出高内聚、低耦合的模块。

### JUnit简介

JUnit 是一个 Java 编程语言的单元测试框架。JUnit 在测试驱动的开发方面有很重要的发展，是起源于 JUnit 的一个统称为 xUnit 的单元测试框架之一。


### 单元测试规范

     1.单元测试类后面加Test；
     
     2.测试方法使用@Test标注；
     
     3.测试方法名之前加test；
     
     4.所有测试方法返回类型必须为void且无参数；
     
     5.每个测试方法之间相互独立；

### JUnit4常用注解

     @Test：把一个方法标记为测试方法
     
     它有两个常用属性:
     
     1.excepted属性是用来测试异常;
     
     2.timeout用来测试性能的，就是测试一个方法能不能在规定时间内完成;
     
     也可使用@Rule规则来规定测试类中的所有方法的超时时间，如果类中的任意一个方法执行时间超过了在Timeout规则中规定的值，测试方法将抛出异常，测试结果为失败（超时参数是以毫秒记）。如:
     
        @Rule
        
        public Timeout timeout = new Timeout(1000);
        
     @Before：每一个测试方法执行前自动调用一次；
     
     @After：每一个测试方法执行完自动调用一次；
     
     @BeforeClass：所有测试方法执行前执行一次，在测试类还没有实例化就已经被加载，所以用static修饰；
     
     @AfterClass：所有测试方法执行完执行一次，在测试类还没有实例化就已经被加载，所以用static修饰；
     
     @Ignore：禁止执行junit测试类的某些或者全部测试方法,应用在方法或类上；

```java
public class AnnotationTest {

    int i;

    public AnnotationTest(){
        System.out.println("构造方法");
    }

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
        System.out.println("i="+i++);
    }

    @Test
    public void test2(){
        System.out.println("Test2");
        System.out.println("i="+i++);
    }

    @Ignore
    public void test3(){
        System.out.println("Test3");
    }
}

输出结果:

BeforClass

构造方法

Before

Test1

i=0

After

构造方法

Before

Test2

i=0

After

AfterClass

```

### JUnit4异常和超时测试

被测类：

```java
public class MyMath {
    /**
     * 递归阶乘
     * @param n
     * @return
     * @throws Exception
     */
    public int factorial(int n) throws Exception {
        if (n < 0) throw new Exception("负数没有阶乘");
        else if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fibonacci(int n){
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * 冒泡排序
     * @param array
     */
    public void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void quickSort(int[] array){

    }
}
```


测试类：

```java
public class MyMathTest {
    
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
}
```

### JUnit4常用断言方法

     assertNull(java.lang.Object object) 	检查对象是否为空
     
     assertNotNull(java.lang.Object object) 	检查对象是否不为空
     
     assertEquals(long expected, long actual) 	检查long类型的值是否相等
     
     assertEquals(double expected, double actual, double delta) 	检查指定精度的double值是否相等
     
     assertFalse(boolean condition) 	检查条件是否为假
     
     assertTrue(boolean condition) 	检查条件是否为真
     
     assertSame(java.lang.Object expected, java.lang.Object actual) 	检查两个对象引用是否引用同一对象（即对象是否相等）
     
     assertNotSame(java.lang.Object unexpected, java.lang.Object actual)    检查两个对象引用是否不引用统一对象(即对象不等)
     
     fail(String string)  在没有报告的情况下使测试不通过

```java
public class AssertEqualsTest {
    @Test
    public void testAssertNull(){
        String string = null;
        assertNull(string);
    }

    @Test
    public void testAssertNotNull(){
        String string = "Junit";
        assertNotNull(string);
    }

    @Test
    public void testAssertEqualsLong(){
        long long1 = 1;
        long long2 = 1;
        assertEquals(long1,long2);
    }

    @Test
    public void testAssertEqualsDouble(){
        double double1 = 1.234;
        double double2 = 1.235;
        double delta = 0.002;
        assertEquals(double1,double2,delta);
    }

    @Test
    public void testAssertTrue(){
        List<String> list = new ArrayList<String>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAssertFalse(){
        List<String> list = new ArrayList<String>();
        list.add("junit");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAssertSame(){
        String string1 = "HelloWorld";
        String string2 = "HelloWorld";
        assertSame(string1, string2);
    }

    @Test
    public void testAssertNotSame(){
        String string1 = "Hello Junit";
        String string2 = "Hello World";
        assertNotSame(string1, string2);
    }
}
```

### JUnit4参数化测试

 Junit 4 参数化测试 允许通过变化范围的参数值来测试方法。参数化测试可以通过以下简单的步骤实现：
 
 1.对测试类添加注解 @RunWith(Parameterized.class)；
 
 2.将需要使用变化范围参数值测试的参数定义为私有变量；
 
 3.使用上一步骤声明的私有变量作为入参，创建构造函数；
 
 4.创建一个使用@Parameters注解的公共静态方法，它将需要测试的各种变量值通过集合的形式返回；
 
 5.使用定义的私有变量定义测试方法；

```java
被测类：
public class EvenNumberChecker {
    public boolean isEven(int i){
        if ((i & 1) == 0){
            return true;
        }else return false;
    }
}

测试类：
//第一步
@RunWith(Parameterized.class)
public class EvenNumberCheckerTest {
    //第二步
    private int inputNumber;
    private boolean isEven;
    //第三步
    public EvenNumberCheckerTest(int inputNumber, boolean isEven){
        this.inputNumber = inputNumber;
        this.isEven = isEven;
    }
    //第四步
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
    //第五步
    @Test
    public void testEvenNumberChecker(){
        System.out.println("inputNumber:" + inputNumber + " isEven:" + isEven);
        EvenNumberChecker evenNumberChecker = new EvenNumberChecker();
        boolean result = evenNumberChecker.isEven(inputNumber);
        assertEquals(isEven, result);
    }
}
```

### JUnit4测试套件

 Junit 4允许通过使用测试套件类批量运行测试类 . 为一套测试类创建一个测试套件，要为测试类添加以下注解：
 
 @RunWith(Suite.class)
 
 @SuiteClasses(TestClass1.class, TestClass2.class)
 
 当运行时，所有包含在@SuiteClasses注解内的所有测试类都会被执行。

```java
@RunWith(Suite.class)
@Suite.SuiteClasses({AnnotationTest.class, EvenNumberCheckerTest.class})
public class SuiteTest {
    
}
```

### 总结

随着团队的完善和产品用户量的增长，对软件产品质量的要求越来越高，完善和系统的测试是产品质量最强大的保障。本文通过为什么要做单元测试、JUnit简介、单元测试规范、JUnit4常用注解、JUnit4异常和超时测试、JUnit4常用断言方法、JUnit4参数化测试、JUnit4测试套件等八方面的内容概要介绍了使用JUnit进行单元测试的相关方法，接下来随着JUnit5的到来，一个即将重新定义JVM测试方法的版本，我也就继续完善JUnit进阶内容，欢迎继续关注我的博客：[DevinBlog](http://zhangchuzhao.site)



参考文章： [为什么要做单元测试](http://letsswift.com/2014/06/swift-unit-test/)    [Junit4 Tutorials](http://blog.csdn.net/luanlouis/article/details/37562165)
