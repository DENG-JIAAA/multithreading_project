package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description: 自定义 “线程类” 的几个方法
 */

public class ThreadDemo {
    public static class MyThreadClass extends Thread {
        @Override
        public void run() {
            System.out.println("自定义线程类的 run() 方法");
        }
    }

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("实现 Runnable() 接口实现自定义的线程类");
        }
    }


    public static void main(String[] args) {
        MyThreadClass threadClass = new MyThreadClass();
        // 调用start()方法后，该线程才算启动！
        threadClass.start();

        // 实现 Runnable 接口
        new Thread(new MyThread()).start();

        // Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("匿名内部类（Java 8 函数式编程）");
        }).start();


    }
}
