package top.dj.demo;

import java.util.concurrent.*;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description 为了让任务有能够取消的功能，就使用 Callable 来代替 Runnable 。
 * 如果为了可取消性而使用 Future 但又不提供可用的结果，则可以声明 Future<?> 形式类型、并返回 null 作为底层任务的结果。
 * 在很多高并发的环境下，有可能 Callable 和 FutureTask 会创建多次。FutureTask 能够在高并发环境下确保任务只执行一次。
 */

public class FutureTaskDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算1秒
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new FutureTaskDemo());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
