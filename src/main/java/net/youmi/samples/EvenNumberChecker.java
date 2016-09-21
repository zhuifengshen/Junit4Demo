package net.youmi.samples;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/21 10:47
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class EvenNumberChecker {
    public boolean isEven(int i){
        if ((i & 1) == 0){
            return true;
        }else return false;
    }
}
