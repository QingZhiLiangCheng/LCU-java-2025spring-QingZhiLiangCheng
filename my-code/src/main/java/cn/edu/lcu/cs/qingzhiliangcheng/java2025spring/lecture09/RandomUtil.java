package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture09;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    /**
     * 生成指定长度的随机字符串
     * 该方法使用了加密安全的随机数生成器来确保随机性，适用于生成密码、验证码等需要一定安全性的情景
     *
     * @param length 生成字符串的长度
     * @return 生成的随机字符串
     */
    public static String generateRandomString(int length) {
        // 定义所有可能的字符，包括大写字母、小写字母和数字，以增加生成字符串的多样性
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 使用SecureRandom作为随机数生成器，提供更高级别的随机性
        SecureRandom random = new SecureRandom();
        // 创建StringBuilder用于高效地构建最终的字符串
        StringBuilder sb = new StringBuilder();
        // 循环指定次数，每次随机选择一个字符添加到StringBuilder中
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        // 将构建好的字符串转换为String并返回
        return sb.toString();
    }


    /**
     * 从参与者中随机抽取指定数量的获胜者
     * 此方法首先使用SecureRandom和Collections.shuffle方法确保每个参与者被抽中的概率相同，以保证公平性
     * 然后从洗牌后的列表中取出指定数量的获胜者如果参与者数量少于指定的获胜者数量，则返回所有参与者
     *
     * @param participants 参与者列表，从中抽取获胜者
     * @param winners 指定抽取的获胜者数量
     * @return 包含获胜者的列表，列表长度可能小于指定的获胜者数量，这取决于参与者的总数量
     */
    public static List<String> drawWinners(List<String> participants, int winners) {
        SecureRandom random = new SecureRandom();
        List<String> copy = new ArrayList<>(participants);
        Collections.shuffle(copy, random); // 公平洗牌
        return copy.subList(0, Math.min(winners, copy.size()));
    }

}
