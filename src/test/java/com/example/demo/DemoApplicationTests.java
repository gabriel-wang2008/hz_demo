package com.example.demo;

import com.example.demo.util.Singleton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        String s = "";
        Singleton instance = Singleton.getInstance();

        Converter<String, Integer> ss = Integer::valueOf;
        PersionFactory persionFactory = Persion::new;
        Persion in = persionFactory.create("");

        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);
//        num = 3;
    }

    @FunctionalInterface
    interface PersionFactory<P extends Persion> {
        P create(String s);
    }

    public class Persion {
        public Persion(String s) {

        }
    }
}
