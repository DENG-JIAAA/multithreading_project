package top.dj.test;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 10:19
 * @Description 斐波拉契数列
 */

public class FibonacciSequence {
    static long a = 0, b = 1;

    static BigInteger preInt = new BigInteger("0");
    static BigInteger nextInt = new BigInteger("1");

    public static void main(String[] args) {
        /* Integer，Long 数据类型长度有限，会溢出 */
        fibonacciLongStream();

        /* BigInteger 使用麻烦一点，但不会有溢出问题 */
        fibonacciBigInteger();
    }

    public static void fibonacciLongStream() {
        LongStream.generate(() -> {
            long tmp = a;
            a = b;
            b += tmp;
            return a;
        }).limit(100).forEach(System.out::println);
    }

    public static void fibonacciBigInteger() {
        Stream.generate(() -> {
            BigInteger tmp = preInt;
            preInt = nextInt;
            nextInt = nextInt.add(tmp);
            return preInt;
        }).limit(200).forEach(System.out::println);
    }
}
