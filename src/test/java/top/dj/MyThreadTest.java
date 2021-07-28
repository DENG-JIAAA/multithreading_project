package top.dj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description
 */

@SpringBootTest
public class MyThreadTest {

    @Test
    void test() throws InterruptedException {
        Thread thread = new Thread(() -> {});
        Thread anoThread = new Thread(() -> {});
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
        thread.notify();
        System.out.println(thread.getState());
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            System.out.println("正在执行方法......");
            Thread.sleep(2000L);
            System.out.println("执行完毕。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * BLOCKED 与 RUNNABLE 状态的转换
     */
    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        //Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + " : " + a.getState()); // 输出？
        System.out.println(b.getName() + " : " + b.getState()); // 输出？
    }

    @Test
    void waitingTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        a.start();
        a.join();
        b.start();
        System.out.println(a.getName() + " : " + a.getState()); // 输出？
        System.out.println(b.getName() + " : " + b.getState()); // 输出？
    }

    @Test
    void timedWaitingTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        a.start();
        a.join(1000L);
        b.start();
        System.out.println(a.getName() + " : " + a.getState()); // 输出？
        System.out.println(b.getName() + " : " + b.getState()); // 输出？
    }

}
