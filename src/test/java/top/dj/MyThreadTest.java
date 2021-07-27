package top.dj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author DengJia
 * @Date 2021/7/26
 * @Description
 */

@SpringBootTest
public class MyThreadTest {

    @Test
    void test() {
        Thread thread = new Thread(() -> {
        });
        thread.start();
    }

}
