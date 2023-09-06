package cn.edu.lcu.cs.util;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author ling
 */
public class StringUtils {

    public static boolean isEmpty(String string) {
        return string == null || string.trim().equals("");
    }

    /**
     * 将带下划线的字符串转换为驼峰模式<br>
     * 如：map_under_score_to_camel_case to MapUnderScoreToCamelCase
     *
     * @param underScoreString 转换前的字符串
     * @return 转换后的字符串
     */
    public static String mapUnderScoreToCamelCase(String underScoreString) {
        if (isEmpty(underScoreString)) {
            return null;
        }
        // 拆分字符串
        return Arrays.stream(underScoreString.split("_"))
                // 每个单词首字母大写
                .map(StringUtils::toUpperCaseFirstLetter)
                // 归约，合并字符串数组为单个字符串
                .reduce("", (result, item) -> result + item);
    }

    public static String toUpperCaseFirstLetter(String src) {
        char[] chars = src.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            // 小写字母转大写字母，小写大写字母的ASCII码相差 0X20
            chars[0] -= 0X20;
            return String.valueOf(chars);
        }
        return src;
    }

    public static String toLowerCaseFirstLetter(String src) {
        char[] chars = src.toCharArray();
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            // 小写字母转大写字母，小写大写字母的ASCII码相差 0X20
            chars[0] += 0X20;
            return String.valueOf(chars);
        }
        return src;
    }

    /**
     * 将（首字母小写的）驼峰模式的字符串转换为下划线风格的字符串
     *
     * @param camelCaseString 转换前
     * @return 转换后
     */
    public static String mapCamelCaseToUnderScore(String camelCaseString) {
        return camelCaseString.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * 检测文本是否满足某些测试条件，演示Predicate函数式接口的使用。
     *
     * @param text
     * @param predicate
     * @return
     */
    public static boolean test(String text, Predicate<String> predicate) {
        return predicate.test(text);
    }
}
