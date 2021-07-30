//package top.dj.test;
//
//import com.sun.deploy.util.StringUtils;
//import org.omg.CORBA.WStringSeqHelper;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Supplier;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
///**
// * @Author DengJia
// * @Date 2021/7/29 17:26
// * @Description 创建Stream
// */
//
//public class CreateStream {
//    public static void main(String[] args) throws IOException {
//        // 方法1: Stream.of()
//        // m1();
//
//        // 方法2: 基于数组或Collection
//        m2();
//
//        // 方法3: 基于Supplier
//        // m3();
//
//        // 其他方法: 三方API
//        // om();
//
//        // test();
//    }
//
//    public static void test() {
//        /*
//            以指定字符分割
//         */
//        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
//        String str = StringUtils.join(Arrays.asList(arr), ", ");
//        System.out.println(str);
//
//        String[] arr2 = {"abc", "", "bc", "efg", "abcd", "", "jkl"};
//        List<String> list = Arrays.asList(arr2);
//        String collect = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
//        System.out.println(collect);
//    }
//
//    public static void om() throws IOException {
//        /*
//            创建Stream的第三种方法是通过一些API提供的接口，直接获得Stream。
//            例如，Files类的lines()方法可以把一个文件变成一个Stream，每个元素代表文件的一行内容：
//         */
//        Path path = Paths.get("E:\\dev\\Tomcat\\apache-tomcat-9.0.50\\conf\\server.xml");
//        Stream<String> lines = Files.lines(path);
//        // lines.forEach(System.out::println);
//
//        Pattern pattern = Pattern.compile("\\s+");
//        Stream<String> stream = pattern.splitAsStream("The quick brown fox jumps over the lazy dog");
//        stream.forEach(System.out::println);
//    }
//
//    public static void m3() {
//        Stream<Integer> natual = Stream.generate(new NatualSupplier());
//        // System.out.println(natual.limit(100).count());
//        natual.limit(100).forEach(System.out::println);
//    }
//
//    public static void m2() {
//        /*
//            基于一个数组或者Collection，这样该Stream输出的元素就是数组或者Collection持有的元素
//         */
//
//        // 整型Stream
//        Stream<String> stream = Arrays.stream(new String[]{"中" + "国" + "加" + "油"});
//        stream.forEach(System.out::println);
//
//        // 基本数据类型（int）Stream
//        IntStream is = Arrays.stream(new int[]{1, 2, 3});
//        is.forEach(System.out::println);
//    }
//
//    public static void m1() {
//        Stream<String> stream = Stream.of("A", "B", "C", "D");
//        /*
//            forEach -- 内部循环调用
//            可传入符合Consumer接口的void accept(T t);的方法引用
//         */
//        stream.forEach(System.out::println);
//    }
//}
//
//class NatualSupplier implements Supplier<Integer> {
//    int i = 0;
//    @Override
//    public Integer get() {
//        i++;
//        return i;
//    }
//}
