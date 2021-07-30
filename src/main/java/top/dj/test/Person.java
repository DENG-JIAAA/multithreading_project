package top.dj.test;

/**
 * @Author DengJia
 * @Date 2021/7/29 16:48
 * @Description
 */

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
