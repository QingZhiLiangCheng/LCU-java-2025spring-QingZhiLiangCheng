package cn.edu.lcu.cs.javaprogramming.enumdemo;

import lombok.ToString;

public enum Color {
    RED("红"), GREEN("绿"), BLUE("蓝");

    private String name;

    private Color(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
