package top.dj.theory;

/**
 * @Author DengJia
 * @Date 2021/7/29 11:40
 * @Description 两个写法作用等价
 */

public class SynchronizedExampleB {

    // 关键字在静态方法上，锁为当前Class对象
    public static synchronized void classLock() {

    }

    // 关键在在代码块上，锁为括号内的对象
    public void blockLock() {
        synchronized (this.getClass()) {
            // code
        }
    }
}
