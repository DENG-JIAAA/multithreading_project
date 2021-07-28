package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/27
 * @Description 锁与同步
 */


public class NoneLockDemo {
    private static final Object lock = new Object(); // 使用一个对象锁

    static class T1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    if (i == 51) {
                        // 使用lock.wait()让自己进入等待状态。这个时候，lock这个锁是被释放了的。
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "( T1 --- ) --> " + i);
                }
            }
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    // notify()方法会随机叫醒一个正在等待的线程，而notifyAll()会叫醒所有正在等待的线程。
                    if (i == 51) lock.notify();
                    System.out.println(Thread.currentThread().getName() + "( T2 +++ ) --> " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new T1()).start();
        new Thread(new T2()).start();
    }
}
