package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;

import lombok.Data;
import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 成绩工具类
 *
 * @author ling
 * @date 2022/4/11 17:10
 */
@Data
public class ScoreUtil {
    private static final int studentAmount = 84;
    /**
     * 成绩列表，接口类型。不要声明为任何实现类。
     */
    @Getter
    private static Set<Score> scores;

    /**
     * 仅运行一次，静态初始化。
     */
    static {
        scores = new HashSet<>();

        for (int i = 0; i < studentAmount; i++) {
            Score score = nextScore();
            score.setId((long) i);
            // 追加对象到列表尾部
            // 列表的容量会根据容纳元素的多少自动调整
            scores.add(score);
        }
    }

    /**
     * 随机生成下一个成绩对象。
     *
     * @return
     */
    public static Score nextScore() {
        Random random = new Random();
        // 将随机生成的10000以内的整数格式化为4字符宽度的字符串
        int r = random.nextInt(10000);
        String randomString = String.format("%04d", r);

        Score score = Score.builder()
                .id((long) r)
                .clazzName(random.nextBoolean() ? "3班" : "4班")
                .studentName("学生" + randomString)
                .studentNo("202020" + randomString)
                .ordinaryScore(nextPercentageScore())
                .midtermScore(nextPercentageScore())
                .termScore(nextPercentageScore())
                .experimentScore(nextPercentageScore())
                .build();
        return score;
    }

    public static void print(Collection<Score> scores) {
        scores.forEach(System.out::println);
    }

    /**
     * 随机生成百分制成绩
     *
     * @return
     */
    private static int nextPercentageScore() {
        return new Random().nextInt(101);
    }

}
