package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture09.util;


import cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture09.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void isEmpty() {
    }

    @Test
    void mapUnderScoreToCamelCase() {
    }

    @Test
    void toUpperCaseFirstLetter() {
        assertEquals("Hello", StringUtils.toUpperCaseFirstLetter("hello"));
        assertEquals("H", StringUtils.toUpperCaseFirstLetter("h"));
        assertEquals("", StringUtils.toUpperCaseFirstLetter(""));
        assertEquals(null, StringUtils.toUpperCaseFirstLetter(null));
    }

    @Test
    void toLowerCaseFirstLetter() {
        assertEquals("hello", StringUtils.toLowerCaseFirstLetter("Hello"));
        assertEquals("h", StringUtils.toLowerCaseFirstLetter("H"));
        assertEquals("", StringUtils.toLowerCaseFirstLetter(""));
        assertEquals(null, StringUtils.toLowerCaseFirstLetter(null));
    }

    @Test
    void toUpperCaseFirstChar() {
        assertEquals("Hello", StringUtils.toUpperCaseFirstChar("hello"));
        assertEquals("H", StringUtils.toUpperCaseFirstChar("h"));
        assertEquals("", StringUtils.toUpperCaseFirstChar(""));

    }

    @Test
    void toLowerCaseFirstChar() {
        assertEquals("hello", StringUtils.toLowerCaseFirstChar("Hello"));
        assertEquals("h", StringUtils.toLowerCaseFirstChar("H"));
        assertEquals("", StringUtils.toLowerCaseFirstChar(""));
        assertEquals(null, StringUtils.toLowerCaseFirstChar(null));
    }

    @Test
    void mapCamelCaseToUnderScore() {
    }

    @Test
    void test1() {
    }

    /**
     * 在Java中，字符串的大小写转换方法（如toUpperCase和toLowerCase）会根据指定的Locale来进行转换。对于非英语字符，不同的语言和地区可能有不同的大小写转换规则。
     */
    @Test
    void toUpperCaseNonEnglish() {
        assertEquals("STRASSE", "straße".toUpperCase());
        assertEquals("MÜLLER", "müller".toUpperCase());
        assertEquals("SS", "ß".toUpperCase());
    }

    @Test
    void toLowerCaseNonEnglish() {
        // 测试德语中的特殊字符转换
        assertEquals("müller", "MÜLLER".toLowerCase(Locale.GERMANY), "德语中 'Ü' 的小写形式应为 'ü'");

        // 测试其他语言的特殊字符转换
        assertEquals("café", "CAFÉ".toLowerCase(Locale.FRANCE), "法语中 'É' 的小写形式应为 'é'");

        // 测试 Unicode 特殊字符
        assertEquals("π", "Π".toLowerCase(Locale.US), "希腊字母 'Π' 的小写形式应为 'π'");
        assertEquals("ω", "Ω".toLowerCase(Locale.US), "希腊字母 'Ω' 本身是小写形式");

        // 测试空字符串
        assertEquals("", "".toLowerCase(Locale.US), "空字符串的小写形式应为自身");

    }
}
