package top.dj.demo;

import java.util.concurrent.Semaphore;

/**
 * @Author DengJia
 * @Date 2021/7/27
 * @Description
 */

public class WaitAndNotifyDemo  {
    static final Object lock = new Object();

    static class ThreadA implements Runnable  {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Thread A --> " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Thread B --> " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }

}
