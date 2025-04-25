package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring;


import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.text.NumberFormat;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.NANOS;

@Log
public class BaseTest {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    /**
     * 测试方法起始时刻
     */
    Instant begin;
    /**
     * 测试方法结束时刻
     */
    Instant end;


    @BeforeEach
    void beforeEach() {
        begin = Instant.now();
    }

    @AfterEach
    void afterEach() {
        end = Instant.now();
        // 计算测试方法结束与起始之间耗费的纳秒数
        long nanos = begin.until(end, NANOS);
        // 两种计算方法均可
        // java.time.temporal.ChronoUnit 枚举类型，一组标准的日期时间单位。
        //long nanos = NANOS.between(begin, end);

        System.out.println("耗费时间（纳秒）：" + numberFormat.format(nanos));
        System.out.println("---------------------------------------------------------");
    }
}
