package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description Java线程的六个状态
 */

public class ThreadState {
    public static void main(String[] args) {
        getThreadState();
    }

    public static void getThreadState() {
        // 1、还没调用Thread实例的start()方法。
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());

        // 2、
        thread.start();
        System.out.println(thread.getState());


    }
}
