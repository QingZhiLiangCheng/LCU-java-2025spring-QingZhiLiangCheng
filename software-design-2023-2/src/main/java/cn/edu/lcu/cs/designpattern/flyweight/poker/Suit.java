package cn.edu.lcu.cs.designpattern.flyweight.poker;

/**
 * 扑克花色
 */
public enum Suit {
    // 梅花
    CLUBS("梅花"),
    // 方块
    DIAMONDS("方块"),
    // 黑桃
    SPADES("黑桃"),
    // 红桃
    HEARTS("红桃");

    @Override
    public String toString() {
        return name;
    }

    private String name;

    private Suit(String name) {
        this.name = name;
    }
}
