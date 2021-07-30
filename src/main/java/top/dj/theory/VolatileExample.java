package top.dj.theory;

/**
 * @Author DengJia
 * @Date 2021/7/29
 * @Description 内存可见性
 * 如果flag变量没有用volatile修饰，线程A的本地内存里面的变量就不会立即更新到主内存，
 * 那随后线程B也同样不会去主内存拿最新的值，仍然使用线程B本地内存缓存的变量的值a = 0，flag = false。
 */

public class VolatileExample {
    int i = 0;
    volatile boolean flag = false;

    public void writer() {
        i = 1;
        /*
            写：
            当一个线程对volatile修饰的变量进行写操作时，
            JMM会立即把该线程对应的本地内存中的共享变量的值刷新到主内存。
         */
        flag = true;
    }

    public void reader() {
        /*
            读：
            当一个线程对volatile修饰的变量进行读操作时，
            JMM会把立即该线程对应的本地内存置为无效，
            从主内存中读取共享变量的值。
         */
        if (flag) {
            System.out.println("i：" + i);
        }
    }
    
}
