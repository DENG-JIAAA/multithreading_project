package top.dj.demo;

import javafx.concurrent.Task;

import java.util.concurrent.*;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description: 自定义 Callable
 */

public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        Future<Integer> future = executor.submit(callableDemo);

        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(future.get());
    }
}
