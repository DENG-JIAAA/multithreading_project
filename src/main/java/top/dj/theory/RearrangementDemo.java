package top.dj.theory;

/**
 * @Author DengJia
 * @Date 2021/7/28
 * @Description 指令重排序举例，为了减少停顿，我们可以先加载e和f,然后再去加载add(b,c)。
 */

public class RearrangementDemo {
    public static void main(String[] args) {
        int b = 1;
        int c = 2;
        int e = 3;
        int f = 4;

        int a = b + c;
        int d = e + f;

        System.out.println(a);
        System.out.println(d);
    }
}
