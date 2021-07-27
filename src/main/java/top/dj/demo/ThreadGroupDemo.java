package top.dj.demo;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description ThreadGroup 管理着它下面的 Thread，ThreadGroup 是一个标准的向下引用的树状结构，
 * 这样设计的原因是防止 "上级" 线程被 "下级" 线程引用而无法有效地被 GC 回收。
 */

public class ThreadGroupDemo {
    public static void main(String[] args) {
        // testThreadGroup();
        // maxPriority();
        commonMethod();
    }

    public static void commonMethod() {
        System.out.println("获取当前线程组的名字" + Thread.currentThread().getThreadGroup().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
    }

    /**
     * 如果某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取而代之的是线程组的最大优先级。
     */
    public static void maxPriority() {
        ThreadGroup threadGroup = new ThreadGroup("tg1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("threadGroup 线程组的优先级：" + threadGroup.getMaxPriority());
        System.out.println("thread 线程的优先级：" + thread.getPriority());
    }

    public static void testThreadGroup() {
        Thread oneThread = new Thread(() -> {
            System.out.println("--- oneThread 当前线程组的名字：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("--- oneThread 当前线程的名字：" + Thread.currentThread().getName());
        });
        oneThread.start();
        System.out.println("+++ 执行 main 当前线程组的名字：" + Thread.currentThread().getThreadGroup().getName());
        System.out.println("+++ 执行 main 当前线程的名字：" + Thread.currentThread().getName());
    }


}
