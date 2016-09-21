package net.youmi.samples;

/**
 * Created by Devin on 2016/9/20.
 */
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
