package net.youmi.samples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Devin on 2016/9/20.
 */
public class MessagerTest {
    Messager messager;
    @Before
    public void setUp() throws Exception {
        messager = new Messager();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getMessage() throws Exception {
        assertEquals("junit", messager.getMessage());
    }

}