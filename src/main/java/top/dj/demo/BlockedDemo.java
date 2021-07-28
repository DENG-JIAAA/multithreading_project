package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/27
 * @Description BLOCKED 与 RUNNABLE 状态的转换
 */

public class BlockedDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                oneMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                oneMethod();
            }
        }, "b");

        a.start();
        b.start();
        System.out.println(a.getName() + " : " + a.getState());
        System.out.println(b.getName() + " : " + b.getState());
    }

    // 同步方法争夺锁
    private static synchronized void oneMethod() {
        try {
            System.out.println("睡眠 2 秒");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
