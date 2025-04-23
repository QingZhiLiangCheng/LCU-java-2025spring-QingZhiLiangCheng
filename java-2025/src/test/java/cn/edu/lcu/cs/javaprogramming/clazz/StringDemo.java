package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import cn.edu.lcu.cs.javaprogramming.oop.Dog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 字符串演示
 *
 * @author ling
 * @date 2022/4/1 23:16
 */
public class StringDemo extends BaseTest {

    @Test
    void newDemo(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        s3 += "!";
        String s4 = new String("hello");
        System.out.println("(s1==s2) = " + (s1 == s2));
        System.out.println("s1.equals(s2) = " + s1.equals(s2));

        System.out.println("(s1==s4) = " + (s1 == s4));
        System.out.println("s1.equals(s4) = " + s1.equals(s4));






    }



    /**
     * 将带下划线的字符串转换为驼峰模式<br>
     * 如：map_under_score_to_camel_case to MapUnderScoreToCamelCase
     *
     * @param underScoreString 转换前的字符串
     */
    @ParameterizedTest
    @ValueSource(strings = {"map_under_score_to_camel_case_a"})
    void mapUnderScoreToCamelCase(String underScoreString) {
        String camelCase = null;
        // 代码填空
        String[] split = underScoreString.split("_");
        StringBuilder sb = new StringBuilder();
        for (String item : split) {
            sb.append(toUpperCaseFirstLetter(item));
        }
        camelCase = sb.toString();

        assertEquals("MapUnderScoreToCamelCaseA", camelCase);
    }

    /**
     * 将字符串首字母大写
     *
     * @param src
     * @return
     */
    String toUpperCaseFirstLetter(String src) {
        // 代码填空
        if (src == null || src.trim().length() == 0) {
            return "";
        }

        return Character.toUpperCase(src.charAt(0)) + src.substring(1);
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
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        System.out.println("(dog1==dog2) = " + (dog1 == dog2));

        // 字符串是特殊的对象，在堆上分配，不可更改，唯一
        String lisi1 = "lisi";
        String lisi2 = "lisi";
        String lisi3 = "LisI".toLowerCase();

        // 两两判断3个串是否相等
        // 代码填空

        System.out.println("lisi1 = " + lisi1);
        System.out.println("lisi2 = " + lisi2);
        System.out.println("lisi3 = " + lisi3);

        System.out.println("lisi1.hashCode() = " + lisi1.hashCode());
        System.out.println("lisi2.hashCode() = " + lisi2.hashCode());
        System.out.println("lisi3.hashCode() = " + lisi3.hashCode());

        System.out.println("(lisi1==lisi2) = " + (lisi1 == lisi2));
        System.out.println("(lisi1==lisi3) = " + (lisi1 == lisi3));
        System.out.println("(lisi2==lisi3) = " + (lisi2 == lisi3));

        System.out.println("lisi1.equals(lisi2) = " + lisi1.equals(lisi2));
        System.out.println("lisi1.equals(lisi3) = " + lisi1.equals(lisi3));
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
        split = string.split("[- :]");


        assertEquals("[2021, 04, 18, 22, 23, 28]", Arrays.toString(split));

        String url = "http://ee-c.lcu.edu.cn/";
        String[] split2 = null;
        // 代码填空
        split2 = url.split("[:/.]");

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