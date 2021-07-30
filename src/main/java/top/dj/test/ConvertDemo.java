package top.dj.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author DengJia
 * @Date 2021/7/30 17:20
 * @Description
 */

public class ConvertDemo {
    public static void main(String[] args) {
        /* 将数组输出为集合 */
        // arrayToList();

        /* 将集合输出为数组 */
        // listToArray();

        outputByGroup();

    }

    public static void arrayToList() {
        String[] array = {"JAVA   ", "c++", "", "         Python", null};
        Stream<String> stream = Stream.of(array);
        List<String> list = stream
                .filter(s -> s != null && !s.isEmpty())
                .map(String::trim)
                .collect(Collectors.toList());
        System.out.println(" -- Array 转换为 List -- ");
        list.forEach(System.out::println);
    }

    public static void listToArray() {
        List<String> list = new ArrayList<String>(){{
            add("Language");
            add("Mathematics");
            add("English");
        }};
        String[] array = list.toArray(new String[0]);
        System.out.println("\n -- List 转换为 Array -- ");
        for (String arr : array) {
            System.out.println(arr);
        }
    }

    public static void outputByGroup() {
        List<String> list = new ArrayList<String>(){{
            add("Apple");
            add("Banana");
            add("Blackberry");
            add("Coconut");
            add("Avocado");
            add("Cherry");
            add("Apricots");
        }};

        Map<String, List<String>> groups = list.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }
}
