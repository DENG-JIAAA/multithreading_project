package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/28
 * @Description
 */

public class JoinDemo {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("子线程睡 3 秒......");
                Thread.sleep(3000L);
                System.out.println("睡完 3 秒。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        System.out.println("是否使用join()，影响主线程的此行语句是否先打印。");
    }
}
