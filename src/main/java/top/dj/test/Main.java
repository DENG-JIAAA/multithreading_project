package top.dj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author DengJia
 * @Date 2021/7/30 15:55
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        // 按行读取配置文件:
        List<String> props= new ArrayList<String>(){{
            add("profile=native");
            add("debug=true");
            add("logging=warn");
            add("interval=500");
        }};
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    HashMap<String, String> hashMap = new HashMap<String, String>() {{
                        put(ss[0], ss[1]);
                    }};
                    return hashMap;
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}


