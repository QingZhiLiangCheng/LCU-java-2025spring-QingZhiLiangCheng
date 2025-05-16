package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 通过成绩单演示Set操作。
 *
 * @author ling
 * @date 2022/4/11 17:10
 */
@Data
public class ScoreSet {
    private static final int studentAmount = 84;
    /**
     * 成绩列表，接口类型。不要声明为任何实现类。
     */
    @Getter
    private static Set<Score> scores;

    /**
     * 在所有测试方法执行前运行本方法，仅运行一次，静态初始化。
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

        // 设置平时成绩
        setOrdinaryScores();
    }

    /**
     * 随机生成下一个成绩对象。
     *
     * @return
     */
    private static Score nextScore() {
        Random random = new Random();
        // 将随机生成的10000以内的整数格式化为4字符宽度的字符串
        String randomString = String.format("%04d", random.nextInt(10000));

        Score score = Score.builder()
                .clazzName(random.nextBoolean() ? "3班" : "4班")
                .studentName("学生" + randomString)
                .studentNo("202020" + randomString)
                .build();
        return score;
    }

    /**
     * 随机生成成绩，并给成绩列表中的各项的平时成绩赋值。
     */
    private static void setOrdinaryScores() {
        // 随机生成若干个成绩
        int[] randomScores = new Random().ints(studentAmount, 0, 101).toArray();
        // 循环将随机成绩赋值给成绩列表中的

        scores.forEach(score -> score.setOrdinaryScore(randomScores[score.getId().intValue()]));
        // 集合没有顺序，没有index的概念
        //for (Score score : scores) {
        //    score.setOrdinaryScore(randomScores[score.getId().intValue()]);
        //}

    }

    /**
     * 遍历打印指定的成绩单
     */
    public void print() {
        scores.forEach(System.out::println);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public Score findById(Long id) {
        Score found = null;

        // 代码填空
        try {
            for (Score score : scores) {
                if (score.getId().equals(id)) {
                    found = score;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }

    /**
     * 修改更新成绩
     *
     * @param score
     * @return 成功修改的元素个数
     */
    public int update(Score score) {
        // 代码填空
        // 先从集合中找到这个元素
        // 再用这个元素替换旧元素
        // 但是集合Set比较特殊，它会自动查找对应的元素
        // 如果找不到，就添加；如果找到，就替换
        scores.add(score);

        return 0;
    }
}
