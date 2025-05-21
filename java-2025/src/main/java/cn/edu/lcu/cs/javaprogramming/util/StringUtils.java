package cn.edu.lcu.cs.javaprogramming.util;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * <p>自定义标识符的命名规范</p>
 * <ul>
 * <li>驼峰命名法 <code>CamelCase</code>
 * <ul>
 * <li>小驼峰 <code>lowerCamelCase</code></li>
 * <li>大驼峰 <code>UpperCamelCase</code></li>
 * </ul>
 * </li>
 * <li>帕斯卡模式 <code>PascalCase</code></li>
 * <li>蛇形命名法 <code>snake_case</code>
 * <ul>
 * <li><code>lower_case_with_underscores</code></li>
 * <li><code>UPPER_CASE_WITH_UNDERSCORES</code></li>
 * </ul>
 * </li>
 * <li>（烤）串式命名法 <code>kebab-case</code>（脊柱命名法 <code>spinal-case</code>，<code>train-case</code>）</li>
 * </ul>
 *
 * @author ling
 */
public class StringUtils {

    /**
     * 检查给定的字符串是否为空或仅包含空白
     *
     * @param string 待检查的字符串
     * @return 如果字符串为空或仅包含空白，则返回true；否则返回false
     */
    public static boolean isEmpty(String string) {
        // 检查字符串是否为null或在去除前后空格后是否为空字符串
        if (string==null || string.trim().equals("")) {
            return true;
        }
        return false;
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
                .map(StringUtils::toUpperCaseFirstChar)
                // 归约，合并字符串数组为单个字符串
                .reduce("", (result, item) -> result + item);
    }

    /**
     * 将字符串的第一个字母转换为大写
     * 如果字符串为空，则直接返回原字符串
     * 此方法仅适用于ASCII字符，对于非ASCII字符（如中文），此方法不会进行转换
     *
     * @param src 待转换的字符串
     * @return 转换后的字符串，如果第一个字符已经是大写或字符串为空，则返回原字符串
     */
    public static String toUpperCaseFirstLetter(String src) {
        if (isEmpty(src)) {
            return src;
        }
        char firstLetter = src.charAt(0);
        if (firstLetter >= 'a' && firstLetter <= 'z') {
            // 将第一个字符转换为大写
            firstLetter -= 0X20;
            // 如果字符串长度为1，则直接返回修改后的字符
            if (src.length() == 1) {
                return String.valueOf(firstLetter);
            } else {
                // 如果字符串长度大于1，则将修改后的字符拼接到字符串的剩余部分
                return firstLetter + src.substring(1);
            }
        }

        return src;
    }

    /**
     * 将字符串的第一个字母转换为小写
     * 如果字符串为空，则直接返回原字符串
     * 此方法主要用于处理英文字符串，对于其他语言的处理可能不适用
     *
     * @param src 待转换的字符串
     * @return 转换后的字符串
     */
    public static String toLowerCaseFirstLetter(String src) {
        if (isEmpty(src)) {
            return src;
        }

        StringBuilder sb = new StringBuilder(src);
        char firstLetter = sb.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z') {
            // 将第一个英文字母转换为小写
            firstLetter += 0X20;
            sb.setCharAt(0, firstLetter);
        }
        return sb.toString();
    }


    /**
     * 将字符串的第一个字符转换为大写
     * 如果字符串为空或第一个字符已经是大写，则直接返回原字符串
     * 此方法仅在第一个字符为小写时对其进行转换
     * 一 壹 ？
     *
     * @param src 待转换的字符串
     * @return 转换后的字符串
     */
    public static String toUpperCaseFirstChar(String src) {
        // 如果字符串为空，则直接返回原字符串
        if (isEmpty(src) || Character.isUpperCase(src.charAt(0))) {
            return src;
        }
        // 将第一个字符转换为大写，并将其余部分拼接回字符串
        return src.substring(0, 1).toUpperCase() + src.substring(1);
    }



    /**
     * 将字符串的第一个字符转换为小写
     * 如果字符串为空或第一个字符已经是小写，则直接返回原字符串
     * 此方法主要用于处理字符串格式化问题，确保字符串的第一个字符为小写
     *
     * @param src 待处理的字符串
     * @return 处理后的字符串，第一个字符为小写
     */
    public static String toLowerCaseFirstChar(String src) {
        // 检查字符串是否为空或第一个字符是否为小写
        if (isEmpty(src) || Character.isLowerCase(src.charAt(0))) {
            return src;
        }
        // 使用StringBuilder来修改字符串的第一个字符为小写
        StringBuilder sb = new StringBuilder(src);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        return sb.toString();
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
