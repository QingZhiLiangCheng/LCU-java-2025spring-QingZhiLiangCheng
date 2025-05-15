package cn.edu.lcu.cs.javaprogramming.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 成绩单集合与映射演示
 * <p>
 * 2022/4/17 16:56
 *
 * @Author ling
 */
class ScoreMapDemo {
    static Set<Score> scoreSet;
    static Map<Long, Score> scoreMap;
    // 查询时用到的成绩ID
    private final long id = 50;
    Instant begin;
    Instant end;

    @BeforeAll
    static void beforeAll() {
        scoreSet = ScoreUtil.getScores();
        scoreMap = new HashMap<>();
        for (Score score : scoreSet) {
            scoreMap.put(score.getId(), score);
        }
    }

    /**
     * 演示查询耗费的时长
     */
//    @Test
    @RepeatedTest(10)
    void findById() {
        long id = 40;
        begin = Instant.now();
        // 从集合中查询
        System.out.println("findByIdFromSet(id) = " + findByIdFromSet(id));
        end = Instant.now();
        System.out.println("列表查询耗费纳秒 " + begin.until(end, ChronoUnit.NANOS));

        begin = Instant.now();
        // 从映射中查询
        System.out.println("findByIdFromMap(id) = " + findByIdFromMap(id));
        end = Instant.now();
        System.out.println("映射查询耗费纳秒 " + begin.until(end, ChronoUnit.NANOS));
    }

    /**
     * 在集合中查询，需要遍历整个集合，效率低。
     */
    Score findByIdFromSet(long id) {
        Score result = null;
        for (Score score : scoreSet) {
            if (score.getId().equals(id)) {
                result = score;
                break;
            }
        }
        return result;
    }


    /**
     * 从映射中根据主键查询，查询效率很高。
     */
    Score findByIdFromMap(long id) {
        return scoreMap.get(id);
    }

    /**
     * 通过keySet遍历映射
     */
    @Test
    void traversalWithKeySet() {
        //代码填空
        Set<Long> keys = scoreMap.keySet();
        for (Long key : keys) {
            System.out.println(scoreMap.get(key));
        }
    }

    /**
     * 通过values遍历映射
     */
    @Test
    void traversalWithValues() {
        //代码填空
        Collection<Score> values = scoreMap.values();
        for (Score value : values) {
            System.out.println(value);
        }

    }

    /**
     * 通过forEach()遍历
     */
    @Test
    void traversalWithForEach() {
        //代码填空
        scoreMap.forEach((k, v) -> System.out.println(v));
    }

    /**
     * 通过entrySet（键值对集合）遍历
     */
    @Test
    void traversalWithEntrySet() {
        //代码填空
        scoreMap.entrySet().forEach(entry -> System.out.println(entry.getValue()));
    }

}