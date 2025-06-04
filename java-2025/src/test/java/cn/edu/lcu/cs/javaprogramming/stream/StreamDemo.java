package cn.edu.lcu.cs.javaprogramming.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    @Test
    void prallelStream() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        System.out.println("*****************************************");

        List<Integer> collect = list.stream().map(item -> {
            System.out.println("串行数据:" + item + ",线程名称:" + Thread.currentThread().getName());
            return item * 2;
        }).collect(Collectors.toList());

        System.out.println("*****************************************");

        List<Integer> collect1 = list.parallelStream().map(item -> {
            System.out.println("并行数据:" + item + ",线程名称:" + Thread.currentThread().getName());
            return item * 2;
        }).collect(Collectors.toList());
    }
}
