package cn.edu.lcu.cs.designpattern.flyweight.poker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * @author ling
 * @date 2022/9/11 20:48
 */
class CardTest {

    @ParameterizedTest
    @EnumSource
        //@EnumSource(Suit.class)
    void getCard(Suit suit/*, Rank rank*/) {
        Rank rank = Rank.ACE;
        System.out.println("Card.get(suit, rank) = " + Card.get(suit, rank));
    }
}