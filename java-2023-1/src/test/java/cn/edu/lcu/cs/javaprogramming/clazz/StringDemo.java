package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 字符串演示
 *
 * @author ling
 * @date 2022/4/1 23:16
 */
public class StringDemo extends BaseTest {
    /**
     * 将带下划线的字符串转换为驼峰模式<br>
     * 如：map_under_score_to_camel_case to MapUnderScoreToCamelCase
     *
     * @param underScoreString 转换前的字符串
     */
    @ParameterizedTest
    @ValueSource(strings = {"map_under_score_to_camel_case"})
    void mapUnderScoreToCamelCase(String underScoreString) {
        String camelCase = null;
        // 代码填空


        assertEquals("MapUnderScoreToCamelCase", camelCase);
    }

    /**
     * 将驼峰模式的字符串转换为下划线风格<br>
     * 如：MapUnderScoreToCamelCase to map_under_score_to_camel_case
     *
     * @param camelCase 转换前的字符串
     */
    @ParameterizedTest
    @ValueSource(strings = {"MapUnderScoreToCamelCase"})
    void mapCamelCaseToUnderScore(String camelCase) {
        String underScore = null;
        // 代码填空


        assertEquals("map_under_score_to_camel_case", underScore);
    }

    /**
     * 将字符串首字母大写
     *
     * @param src
     * @return
     */
    String toUpperCaseFirstLetter(String src) {
        // 代码填空


        return null;
    }

    /**
     * 将字符串首字母小写
     *
     * @param src
     * @return
     */
    String toLowerCaseFirstLetter(String src) {
        // 代码填空


        return null;
    }

    /**
     * 字符串的相等判断，应该用equals方法。
     */
    @Test
    public void equals() {
        // 字符串是特殊的对象，在堆上分配，不可更改，唯一
        String lisi = "lisi";
        String lisi2 = "lisi";
        String lisi3 = "LisI".toLowerCase();

        // 两两判断3个串是否相等
        // 代码填空



    }

    /**
     * 字符串拆分演示。
     */
    @Test
    public void split() {
        String string = "2021-04-18 22:23:28";
        // 依据正则表达式拆分字符串为字符串数组
        String[] split = null;
        // 代码填空


        assertEquals("[2021, 04, 18, 22, 23, 28]", Arrays.toString(split));

        String url = "http://ee-c.lcu.edu.cn/";
        String[] split2 = null;
        // 代码填空

        assertEquals("[http, , , ee-c, lcu, edu, cn]", Arrays.toString(split2));
    }
    /**
     * 根据表名及列名数组，创建sql查询语句。
     */
    @Test
    void selectSql() {
        String table = "student";
        String[] columns = {"id", "name", "studentNo"};

        StringJoiner sql = null;
        // 代码填空



        assertEquals("select id, name, studentNo from student", sql.toString());
    }

}