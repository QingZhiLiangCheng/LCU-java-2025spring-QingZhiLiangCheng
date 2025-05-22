package cn.edu.lcu.cs.javaprogramming.exception;

import org.junit.jupiter.api.Test;

public class ExceptionDemo {

    @Test
    void dividedByZero() {
//        try {
//            System.out.println(10 / 0);
//            System.out.print("整数除以0");
//        } catch (ArithmeticException e) {
//            System.out.print("ArithmeticException");
//            return;
//        } catch (Exception e) {
//            System.out.print("Exception");
//        } finally {
//            System.out.print("Finally");
//        }
        String result = dividedByZeroException();
        System.out.println("-".repeat(80));
        System.out.println(result);


    }
    String dividedByZeroException() {
        try {
            System.out.println(10 / 0);
            System.out.print("整数除以0");
        } catch (ArithmeticException e) {
            System.out.print("ArithmeticException");
//            return "ArithmeticException";
        } catch (Exception e) {
            System.out.print("Exception");
            return "Exception";
        } finally {
            System.out.print("Finally");
            // finally 块中的 return 会覆盖 try 或 catch 块中的 return。
            //如果需要确保 try 或 catch 的返回值不被覆盖，请避免在 finally 块中使用 return。
            //这种行为可能导致代码难以理解和调试，因此建议仅在必要时使用。
            return "Finally";
        }
    }
}
