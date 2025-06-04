package cn.edu.lcu.cs.javaprogramming.collection;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream 演示
 *
 * @author Ling
 */
public class StreamDemo extends BaseTest {
    /**
     * 演示如何创建Stream
     */
    @Test
    public void create() {
        // 如果两手空空，通过Stream.of()创建一个流比较合适
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Object> objs = Stream.of(1, 2, 3, 4, 5, 6, "7");

        // 如果已经存在一个数组，用Arrays.stream()创建一个流最合适
        int[] array = {1, 2, 3, 4, 5};
        IntStream ints2 = Arrays.stream(array);

        // 如果已经有一个Collection对象，用Collection.stream()创建流最合适
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> ints3 = intList.stream();
    }

    /**
     * 喋喋不休的讲话
     *
     * @param talk  重复说的话
     * @param times 重复的次数
     */
    @ParameterizedTest
    @CsvSource({"我不想开学！,10", "叨叨一千遍照样开学！,1000", "谎言帝国非美国莫属！,222", "谎言重复一万次还是谎言！,10000"})
    public void rattleOn(String talk, int times) {
        // 重复返回若干个字符串
        Stream.generate(() -> talk).limit(times).forEach(System.out::println);
    }

    /**
     * 生成指定范围内的整数
     *
     * @param startInclusive 起始数值，包含
     * @param endExclusive   结束数值，不包含
     */
    @ParameterizedTest
    @CsvSource({"1,10", "-3, 9"})
    void range(int startInclusive, int endExclusive) {
        System.out.println("startInclusive = " + startInclusive);
        System.out.println("endExclusive = " + endExclusive);
        System.out.println("[startInclusive, endExclusive) 数值序列如下：");
        int[] ints = IntStream.range(startInclusive, endExclusive).toArray();
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 创建等差序列
     *
     * @param seed  起始数值
     * @param step  步长
     * @param limit 个数限制
     */
    @ParameterizedTest
    @CsvSource({"0,3,10", "-3,2,5"})
    public void arithmeticSequence(int seed, int step, int limit) {
        System.out.println("seed = " + seed);
        System.out.println("step = " + step);
        System.out.println("limit = " + limit);
        System.out.println("等差序列如下：");

        // 以种子为起始，每次增加一个步长
        int[] ints = IntStream.iterate(seed, n -> n + step).limit(limit).toArray();
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 创建等比序列
     *
     * @param seed   起始数值
     * @param factor 比例因子
     * @param limit  个数限制
     */
    @ParameterizedTest
    @CsvSource({"1,2,17", "1,3,10", "1,-3,10", "-3,2,5"})
    public void geometricSequence(int seed, int factor, int limit) {
        System.out.println("seed = " + seed);
        System.out.println("factor = " + factor);
        System.out.println("limit = " + limit);
        System.out.println("等比序列如下：");

        // 使用Stream生成等比序列
        // 代码填空



        int[] ints = null;
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 生成指定个数的随机数
     *
     * @param limit
     */
    @ParameterizedTest
    @ValueSource(ints = {3, 10})
    void generateRandoms(int limit) {
        System.out.println("limit = " + limit);
        System.out.println("随机数序列如下：");

        Random random = new Random();
        Object[] objects = Stream.generate(random::nextInt).limit(limit).toArray();
        System.out.println(Arrays.toString(objects));

        // 此种方式更便捷
        //int[] ints = random.ints(limit).toArray();
        //System.out.println(Arrays.toString(ints));
    }

    /**
     * 利用归约操作求n的阶乘
     */
    @ParameterizedTest
    @ValueSource(longs = {1, 9})
    public void factorial(long n) {
        System.out.println("n = " + n);
        // 生成 [1, n]的整数序列
        LongStream rangeStream = LongStream.range(1, n + 1);
        // 归约是终端操作，流将被关闭
        // 没有指定种子的归约操作，第一个元素默认为种子。
        // 由于序列可能为空，所以返回的是OptionalLong，而不是Long.
        long factorial = rangeStream.reduce((result, item) -> result * item).getAsLong();
        System.out.println("n = " + n);
        System.out.println("factorial = " + factorial);

        // 指定了种子的归约操作
        // 因为指定了种子，能够保证至少返回一个值，所以返回long。
        // 但是因为前边在流上调用了终端操作getAsLong，流被关闭了，如果再调用，就抛异常。
        long factorial2 = rangeStream.reduce(1, (result, item) -> result * item);
        System.out.println("factorial2 = " + factorial2);
    }
}
