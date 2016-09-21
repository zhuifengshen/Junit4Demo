package net.youmi.samples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/21 20:08
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

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
