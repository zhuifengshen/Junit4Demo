package net.youmi.samples;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/21 11:07
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 *
 Junit 4允许通过使用测试套件类批量运行测试类 . 为一套测试类创建一个测试套件，要为测试类添加以下注解：
 @RunWith(Suite.class)
 @SuiteClasses(TestClass1.class, TestClass2.class)
 当运行时，所有包含在@SuiteClasses注解内的所有测试类都会被执行。
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AnnotationTest.class, EvenNumberCheckerTest.class})
public class SuiteTest {

}
