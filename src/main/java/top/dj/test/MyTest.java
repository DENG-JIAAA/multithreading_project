package top.dj.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author DengJia
 * @Date 2021/7/29 15:47
 * @Description
 */

public class MyTest {
    public static void main(String[] args) {
        //withOutLambda();
        withLambda();
    }

    public static void withOutLambda() {
        Integer[] ints = new Integer[]{3, 1, 4, 5, 2};
        for (Integer i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (Integer i : ints) {
            System.out.print(i + " ");
        }
    }

    public static void withLambda() {
        String[] array = new String[]{"Orange", "Banana", "Lemon", "Apple"};
//        Arrays.sort(array, (s1, s2) -> {
//            return s1.compareTo(s2);
//        });

        Arrays.sort(array, (s1, s2) -> s1.compareTo(s2));

        System.out.println(String.join(", ", array));
    }
}
