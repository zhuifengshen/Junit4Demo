package net.youmi.samples;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertThat;

//import static org.hamcrest.CoreMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/5 15:27
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class HamcrestMatcherTest {
    @Test
    public void testHamcrestMatchers(){

        /**
         * 核心匹配：与、或、非、成员、相等、不等
         */

        //allOf: 所有条件都必须满足， 相当于&&
        assertThat("myname", allOf(startsWith("my"), containsString("name")));

        //anyOf: 其中一个满足就通过，相当于||
        assertThat("myname", anyOf(startsWith("his"), containsString("name")));

        //both: &&
        assertThat("myname", both(containsString("my")).and(containsString("name")));

        //either: ||
        assertThat("myname", either(containsString("my")).or(containsString("you")));

        //everyItem: 每个元素都需要满足特定条件
        assertThat(Arrays.asList("my", "mine"), everyItem(startsWith("m")));

        //hasItem: 是否存在这个元素
        assertThat(Arrays.asList("my", "mine"), hasItem("my"));

        //hasItems: 是否存在多个元素
        assertThat(Arrays.asList("me", "i", "my", "mine"), hasItems("me", "my"));

        //is: equalTo(xxx) 或 instanceOf(clazz.class)的简写
        assertThat("myname", is("myname"));
        assertThat("myname", is(String.class));
        assertThat("myname", is(instanceOf(String.class)));
        assertThat("myname", isA(String.class));

        //anything(): 任何情况，都匹配正确
        assertThat("myname", anything());

        //not: ！
        assertThat("myname", is(not("yourname")));
        assertThat("myname", is(not(equalTo("yourname"))));
        assertThat("myname", not("hername"));

        //nullValue(): 值为空
        assertThat(null,  nullValue());

        //notNullValue: 值不为空
        assertThat("myname", notNullValue());

        /**
         * 字符串匹配：包含、顺序、前缀、后缀、空、成员
         */

        //containsString: 包含字符串
        assertThat("myname", containsString("my"));

        //stringContainsInOrder: 顺序包含字符串 (hamcrest-library)
        assertThat("myname", stringContainsInOrder(Arrays.asList("my", "me")));

        //startsWith: 前缀
        assertThat("myname", startsWith("my"));

        //endsWith: 后缀
        assertThat("myname", endsWith("name"));

        //isEmptyString(): 空字符串
        assertThat("", isEmptyString());

        //equalTo: 值相等
        assertThat("myname", equalTo("myname"));
        assertThat(new String[]{"a", "b"}, equalTo(new String[]{"a", "b"}));

        //equalToIgnoringCase: 忽略大小写
        assertThat("myname", equalToIgnoringCase("MYNAME"));

        //equalToIgnoringWhiteSpace: 比较时忽略头尾空格,字符串之间的空格也缩小为一个空格
        assertThat(" my \t  name  ", equalToIgnoringWhiteSpace(" my  name  "));

        //isOneOf: 是否为其中之一
        assertThat("myname", isOneOf("myname", "yourname"));

        //isIn: 是否为其成员
        assertThat("myname", isIn(new String[]{"myname", "yourname"}));

        //hasToString: 被检测值调用toString方法后进行校验 - 对象转换为字符串后进行比较
        assertThat(110, hasToString(equalTo("110")));

        /**
         * 数值匹配：误差、大、小、等于
         */

        //closeTo: [operand, delta] 判断两个数在误差内是否相等,Double/BigDecimal类型
        assertThat(3.14, closeTo(3, 0.5));
        assertThat(new BigDecimal("3.14"), is(closeTo(new BigDecimal("3"), new BigDecimal("0.5"))));

        //comparesEqualTo: 调用actual的compareTo方法进行比较两个值是否相等 - 扩展性比较高
        assertThat(2, comparesEqualTo(2));

        //greaterThan:大于
        assertThat(2, greaterThan(0));

        //greaterThanOrEqualTo: 大于或等于
        assertThat(2, greaterThanOrEqualTo(2));

        //lessThan: 小于
        assertThat(2, lessThan(4));

        //lessThanOrEqualTo: 小于或等于
        assertThat(2, lessThanOrEqualTo(2));

        /**
         * 数组匹配：成员、大小、空、顺序
         */
        //array: 数组长度相等且对应元素也相等
        assertThat(new Integer[]{1, 2, 3}, is(array(equalTo(1), equalTo(2), equalTo(3))));

        //hasItemInArray: 数组是否包含特定元素
        assertThat(new String[]{"my", "you"}, hasItemInArray(startsWith("y")));

        //arrayContainingInAnyOrder: 数组长度和内容相同, 顺序不要求
        assertThat(new String[]{"my", "you"}, arrayContainingInAnyOrder("you", "my"));

        //arrayContaining: 数组相等且属性相同
        assertThat(new String[]{"my", "you"}, arrayContaining("my", "you"));

        //arrayWithSize: 数组长度
        assertThat(new String[]{"my", "you"}, arrayWithSize(2));

        //emptyArray: 空数组
        assertThat(new String[0], Matchers.<String>emptyArray());

        /**
         * 集合匹配: 大小、空、成员
         */

        //hasSize: 集合大小
        assertThat(Arrays.asList("my", "you"), hasSize(equalTo(2)));

        //empty: 空集合
        assertThat(new ArrayList<String>(), is(Matchers.<String>empty()));

        //isIn: 是否为集合成员
        assertThat("my", isIn(Arrays.asList("my", "you")));

        //Map匹配
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "devin");
        //hasEntry: 是否存在某Entry
        assertThat(map, hasEntry("name", "devin"));
        //hasKey: 是否存在某key
        assertThat(map, hasKey("name"));
        //hasValue: 是否存在某value
        assertThat(map, hasValue("devin"));
    }
}
