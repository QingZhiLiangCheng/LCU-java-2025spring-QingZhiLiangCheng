package cn.edu.lcu.cs.designpattern.singleton;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SafeSingletonTest {
    /**
     * 多线程测试：开多个线程，同时调用，测试是否线程安全。
     * 饿汉单例模式，是线程安全的。
     */
    @Test
    void multithreadTest() {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println(SafeSingleton.getInstance());
                }
            }.start();
        }
    }

    @Test
    void equals() {
        SafeSingleton instance1 = SafeSingleton.getInstance();
        SafeSingleton instance2 = SafeSingleton.getInstance();
        if (instance1 == instance2) {
            System.out.println("两个引用指向同一个实例");
        } else {
            System.out.println("两个实例不同");
        }
    }

    /**
     * 用反射破解单例
     */
    @Test
    void equalsWithReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取类对象
        Class<SafeSingleton> clazz = SafeSingleton.class;
        // 获取构造方法
        Constructor<SafeSingleton> constructor = clazz.getDeclaredConstructor();
        // 设置构造方法为可访问的
        constructor.setAccessible(true);
        // 每次调用构造方法，创建不同的实例
        SafeSingleton instance1 = constructor.newInstance();
        SafeSingleton instance2 = constructor.newInstance();
        if (instance1 == instance2) {
            System.out.println("两个引用指向同一个实例");
        } else {
            System.out.println("两个实例不同");
        }
    }
    /**
     * 用反序列化破解单例
     */
    @Test
    void equalsWithSerialization() throws IOException {
        String filename = "instance.obj";
        SafeSingleton instance = SafeSingleton.getInstance();
        // 序列化对象到磁盘文件
        writeOject(filename, instance);
        // 每次从磁盘文件中还原（反序列化）出来的对象都不同
        SafeSingleton instance1 = readObject(filename);
        SafeSingleton instance2 = readObject(filename);
        if (instance1 == instance2) {
            System.out.println("两个引用指向同一个实例");
        } else {
            System.out.println("两个实例不同");
        }
    }

    private void writeOject(String filename, SafeSingleton instance) throws IOException {
        ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(filename));
        outs.writeObject(instance);
        outs.close();
    }

    @SneakyThrows
    private SafeSingleton readObject(String filename) throws FileNotFoundException {
        ObjectInputStream ins = new ObjectInputStream(new FileInputStream(filename));
        SafeSingleton instance = (SafeSingleton) ins.readObject();
        ins.close();
        return instance;
    }

}