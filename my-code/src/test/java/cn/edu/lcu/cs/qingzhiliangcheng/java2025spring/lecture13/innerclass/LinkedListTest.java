package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.innerclass;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void add() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void main() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}