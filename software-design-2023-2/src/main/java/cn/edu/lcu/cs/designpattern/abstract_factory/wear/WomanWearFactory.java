package cn.edu.lcu.cs.designpattern.abstract_factory.wear;

public class WomanWearFactory implements WearFactory {
    @Override
    public Suit buildSuit() {
        return new WomanSuit(100D);
    }

    @Override
    public Shirt buildShirt() {
        return new WomanShirt(99D);
    }

    @Override
    public Shoes buildShoes() {
        return new WomanShoes(98D);
    }
}
