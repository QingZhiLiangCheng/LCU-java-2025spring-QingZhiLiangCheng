package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

import lombok.extern.java.Log;

/**
 * 仅为了演示方法引用，无实际意义。
 *
 * @author ling
 * @date 2022/3/24 23:42
 */
@Log
public class Anything {
    public static String any(String zzz) {
        String msg = "随便一个方法，带一个字符串类型的参数。参数xxx = " + zzz;
        log.info(msg);
        return msg;
    }
}
