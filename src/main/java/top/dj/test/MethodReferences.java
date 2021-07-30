package top.dj.test;

import java.util.Arrays;

/**
 * @Author DengJia
 * @Date 2021/7/29 16:36
 * @Description
 */

public class MethodReferences {
    public static void main(String[] args) {
        String[] strings = new String[]{"F", "A", "S"};
        Arrays.sort(strings, MethodReferences::cmp);
        System.out.println(String.join(", ", strings));

        String[] strs = new String[]{"Z", "O", "H"};
        Arrays.sort(strs, String::compareTo);
        System.out.println(String.join(" - ", strs));
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }


}
