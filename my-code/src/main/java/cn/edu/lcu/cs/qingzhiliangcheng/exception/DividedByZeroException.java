package cn.edu.lcu.cs.qingzhiliangcheng.exception;

/**
 * 除以0的异常
 *
 * @author ling
 * @date 2022/3/25 22:57
 */
public class DividedByZeroException extends ArithmeticException {
    public DividedByZeroException(String message) {
        super(message);
    }

    public DividedByZeroException() {
        super();
    }
}