package top.dj.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 12:28
 * @Description 从一组给定的 LocalDate 中过滤掉工作日，以便得到休息日。
 */

public class StreamFilterDemo {
    static int i = -1;

    public static void main(String[] args) {
        Stream.generate(() -> {
            LocalDate of = LocalDate.of(2021, 1, 1);
            i++;
            return of.plusDays(i);
        }).limit(31).
                filter(ld -> ld.getDayOfWeek() == DayOfWeek.SATURDAY || ld.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }
}
