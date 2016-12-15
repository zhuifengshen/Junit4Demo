package net.youmi.samples;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/6 15:58
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */
@RunWith(Categories.class)
@Suite.SuiteClasses(CalculatorTest.class)
//@Categories.IncludeCategory(CalculatorTest.SmokeTests.class)
//@Categories.ExcludeCategory(CalculatorTest.SmokeTests.class)
//@Categories.IncludeCategory(CalculatorTest.SlowTests.class)
//如果没有指定具体分类, 则全部用例都执行
public class CategoryTest {

}
