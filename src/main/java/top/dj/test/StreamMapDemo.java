package top.dj.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 12:13
 * @Description
 */

public class StreamMapDemo {
    public static void main(String[] args) {
        m2();
    }

    public static void m2() {
        ArrayList<String> list = new ArrayList<String>() {{
            add("    AAA");
            add("cc");
            add("Basdf    ");
        }};

        list.stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 转换小写
                .forEach(System.out::println); // 换行打印
    }

    public static void m1() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> sMap = stream.map(n -> n * n);

        sMap.forEach(System.out::println);
    }
}
