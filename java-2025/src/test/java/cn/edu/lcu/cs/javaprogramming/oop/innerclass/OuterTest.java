package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import org.junit.jupiter.api.Test;

class OuterTest {

    @Test
    void printOfOuter() {
        Outer outer = new Outer();
        outer.print();
    }


    @Test
    void printOfInner() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
}