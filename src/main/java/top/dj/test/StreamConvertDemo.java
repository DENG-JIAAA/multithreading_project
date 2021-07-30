package top.dj.test;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 17:10
 * @Description 对于Stream来说，对其进行转换操作并不会触发任何计算！
 */

public class StreamConvertDemo {
    public static void main(String[] args) {
        Stream<Long> s1 = Stream.generate(new NaturalNumberSupplier());
        Stream<Long> s2 = s1.map(n -> n * n);
        Stream<Long> s3 = s2.map(n -> n - 1);
        s3.limit(20).forEach(System.out::println);
    }
}

class NaturalNumberSupplier implements Supplier<Long> {
    long n = 0;
    @Override
    public Long get() {
        return n++;
    }
}
