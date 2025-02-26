package java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ling
 * @date 2023/2/21 0:00
 */
class HelloWorldTest {

    @Test
    void hello() {
        new HelloWorld().sayHello("lisi");
    }

}