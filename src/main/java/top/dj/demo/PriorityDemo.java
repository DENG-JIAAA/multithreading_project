package top.dj.demo;

import java.util.stream.IntStream;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description Java中的优先级来说不是特别的可靠，Java程序中对线程所设置的优先级只是给操作系统一个建议，操作系统不一定会采纳。
 * 而真正的调用顺序，是由操作系统的线程调度算法决定的。
 */

public class PriorityDemo {
    public static void main(String[] args) {
        // defaultPriority();
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println(String.format("当前执行的线程 --> %s，优先级 --> %d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void defaultPriority() {
        Thread a = new Thread();
        System.out.println("Java Thread 默认优先级：" + a.getPriority());

        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("Java Thread 自定义优先级：" + b.getPriority());
    }
}
