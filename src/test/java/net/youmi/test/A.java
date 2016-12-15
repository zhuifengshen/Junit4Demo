package net.youmi.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/12 18:26
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class A {
    @Test
    public void test1(){
        assertThat(1, is(1));
    }
}
