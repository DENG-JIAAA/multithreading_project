package top.dj.test;

import java.math.BigInteger;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 10:05
 * @Description
 */

public class FibonacciLongStream {
    public static void main(String[] args) {
        fibonacci();
    }

    public static void fibonacci() {
        LongStream longStream = LongStream.generate(new FibonacciSequence2());
        longStream.limit(50).forEach(System.out::println);
    }
}

class FibonacciSequence2 implements LongSupplier {
    long i = 0;
    long j = 1;

    @Override
    public long getAsLong() {
        long temp = j;
        j = i + j;
        i = temp;
        return j;
    }
}
