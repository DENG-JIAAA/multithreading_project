package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/28
 * @Description 信号量
 */

public class SignalDemo {
    private static volatile int signal = 0;

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("ThreadOne --> " + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("ThreadTwo --> " + signal);
                    signal++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }

}
