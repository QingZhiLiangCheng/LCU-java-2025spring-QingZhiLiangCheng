import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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