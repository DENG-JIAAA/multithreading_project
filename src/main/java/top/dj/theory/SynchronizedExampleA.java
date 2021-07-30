package top.dj.theory;

/**
 * @Author DengJia
 * @Date 2021/7/29
 * @Description 两个写法作用等价
 */

public class SynchronizedExampleA {

    // 关键字在当前实例上，锁为当前实例
    public synchronized void instanceLock() {

    }

    // 关键在在代码块上，锁为括号内的对象
    public void blockLock() {
        synchronized (this) {
            // code
        }
    }
}
