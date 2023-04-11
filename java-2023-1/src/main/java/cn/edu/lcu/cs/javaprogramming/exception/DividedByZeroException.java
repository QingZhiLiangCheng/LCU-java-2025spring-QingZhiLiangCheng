package cn.edu.lcu.cs.javaprogramming.exception;

public class DividedByZeroException extends ArithmeticException {

    public DividedByZeroException(String s) {
        super("divided by zero exception");
    }
}
