package top.dj.test;

/**
 * @Author DengJia
 * @Date 2021/7/30 10:27
 * @Description
 */

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.ret());
    }

    public int ret() {
        int a = 1;
        int b = 2;
        return a = b;
    }
}
