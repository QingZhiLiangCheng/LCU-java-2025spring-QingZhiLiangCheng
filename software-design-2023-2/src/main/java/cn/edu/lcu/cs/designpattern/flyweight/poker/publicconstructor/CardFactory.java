package cn.edu.lcu.cs.designpattern.flyweight.poker.publicconstructor;

import cn.edu.lcu.cs.designpattern.flyweight.poker.Rank;
import cn.edu.lcu.cs.designpattern.flyweight.poker.Suit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ling
 * @date 2022/9/12 0:27
 */
public class CardFactory {
    /**
     * 享元对象池，映射类型。
     * key ： 用于唯一识别享元对象，此处为享元对象的hashCode。
     * value ： 享元对象
     * Card hash code to card mapping
     */
    private static final Map<Integer, Card> cards = new HashMap<Integer, Card>();

    //静态初始化52张牌的映射表
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.put(card.hashCode(), card);
            }
        }
    }

    /**
     * 工厂方法，获取指定花色与点数的牌。
     *
     * @param suit
     * @param rank
     * @return
     */
    public static Card getCard(Suit suit, Rank rank) {
        int hash = Objects.hash(suit, rank);
        return cards.get(hash);
    }

}
