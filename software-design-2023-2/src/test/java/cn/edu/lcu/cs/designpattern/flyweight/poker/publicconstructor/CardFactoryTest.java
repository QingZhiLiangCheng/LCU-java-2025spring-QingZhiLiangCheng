package cn.edu.lcu.cs.designpattern.flyweight.poker.publicconstructor;

import cn.edu.lcu.cs.designpattern.flyweight.poker.Rank;
import cn.edu.lcu.cs.designpattern.flyweight.poker.Suit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * TODO 这里是文档说明，如果未提供，把本行删除。
 *
 * @author ling
 * @date 2022/9/12 0:37
 */
class CardFactoryTest {

    @ParameterizedTest
    @EnumSource
        //@EnumSource(Suit.class)
    void getCard(Suit suit/*, Rank rank*/) {
        Rank rank = Rank.ACE;
        System.out.println("CardFactory.getCard(suit, rank) = " + CardFactory.getCard(suit, rank));
    }
}