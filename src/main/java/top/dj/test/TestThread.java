package top.dj.test;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description:
 */

public class TestThread {
    public static class OneThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        // System.out.println(OneThread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        String format = String.format("当前执行的线程 --> ");
        System.out.println(format);
    }
}
