package top.dj.test;

import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 15:36
 * @Description
 */

public class StreamReduceDemo {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, Integer::sum);
        System.out.println(sum); // 45

        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, n) -> acc * n);
        System.out.println(s); // 362880
    }
}
