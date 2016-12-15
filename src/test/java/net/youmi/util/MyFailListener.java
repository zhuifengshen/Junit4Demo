package net.youmi.util;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/12/6 17:43
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class MyFailListener extends RunListener {
    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
        File failFile = new File("faillog.txt");
        if (!failFile.exists()){
            failFile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(failFile, true);
        fileOutputStream.write((failure.toString() + "\n").getBytes());
        fileOutputStream.close();
    }
}
