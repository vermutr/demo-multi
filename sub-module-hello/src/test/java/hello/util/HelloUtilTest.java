package hello.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloUtilTest {

    @Test
    void sayHelloTest() {
        assertEquals("Hello", HelloUtil.sayHello());
    }

}