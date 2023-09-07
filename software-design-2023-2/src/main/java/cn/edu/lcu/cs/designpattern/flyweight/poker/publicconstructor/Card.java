package cn.edu.lcu.cs.designpattern.flyweight.poker.publicconstructor;

import cn.edu.lcu.cs.designpattern.flyweight.poker.Rank;
import cn.edu.lcu.cs.designpattern.flyweight.poker.Suit;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author ling
 * @date 2022/9/12 0:26
 */
@ToString
@Getter
public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * 享元对象公开的构造方法，应该避免直接调用，而是使用专门的工厂类维护对象池，保证各个对象的唯一性。
     *
     * @param suit
     * @param rank
     */
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * 重写hashCode方法，方便工厂方法中判断唯一性。
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
