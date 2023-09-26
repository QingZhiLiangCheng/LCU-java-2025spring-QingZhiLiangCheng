package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO 这里是文档说明，如果未提供，把本行删除。
 *
 * @author ling
 * @date 2023/9/26 23:09
 */
class LazySingletonTest {

    @RepeatedTest(5)
    void getInstance() {
        System.out.println(LazySingleton.getInstance());
    }

    @Test
    void getInstanceMultithread() {
        int count = 5;
        for (int i = 0; i < count; i++) {
            new Thread(() -> System.out.println(LazySingleton.getInstance())).start();
        }
    }

    public static void main(String[] args) {

        int count = 10;
        for (int i = 0; i < count; i++) {
            new Thread(() -> System.out.println(LazySingleton.getInstance())).start();
        }
    }

}