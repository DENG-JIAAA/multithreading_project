package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description 线程组统一异常处理
 */

public class ThreadGroupExceptionDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("tg01") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " --> " + e.getMessage());
            }
        };

        Thread thread = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("线程抛出运行异常");
            }
        });

        thread.start();
    }
}
