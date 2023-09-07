package cn.edu.lcu.cs.designpattern.flyweight.poker;

import lombok.Getter;
import lombok.ToString;

import java.util.EnumMap;
import java.util.Map;

/**
 * 扑克牌
 *
 * @author ling
 * @date 2022/9/11 19:33
 */
@Getter
@ToString
public class Card {
    /**
     * 花色
     */
    private Suit suit;
    /**
     * 点数
     */
    private Rank rank;

    /**
     * 享元对象池。
     * 用二维映射存储52张扑克牌，保证每张牌只有一个实例。
     * 也可以用二维数组存储52张牌。
     */
    private final static Map<Suit, Map<Rank, Card>> cardPool = new EnumMap<>(Suit.class);

    // 静态初始化52张扑克牌的映射，保证每张牌只有一个实例。
    static {
        for (Suit suit : Suit.values()) {
            Map<Rank, Card> rankMap = new EnumMap<Rank, Card>(Rank.class);
            for (Rank rank : Rank.values()) {
                rankMap.put(rank, new Card(suit, rank));
            }
            cardPool.put(suit, rankMap);
        }
    }

    /**
     * 提供公开的接口，供外部调用，根据花色与点数返回唯一的扑克版实例。
     *
     * @param suit
     * @param rank
     * @return
     */
    public static Card get(Suit suit, Rank rank) {
        return cardPool.get(suit).get(rank);
    }

    /**
     * 构造方法私有，防止外部被滥用，从而生成多个实例。
     * 因为构造方法是私有的，享元对象池只能在本类中定义、初始化。
     *
     * @param suit
     * @param rank
     */
    private Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

}
