package cn.edu.lcu.cs.design_pattern.abstract_factory.wear;

public class ManWearFactory implements WearFactory {
    @Override
    public Suit buildSuit() {
        return new ManSuit(100D);
    }

    @Override
    public Shirt buildShirt() {
        return new ManShirt(99D);
    }

    @Override
    public Shoes buildShoes() {
        return new ManShoes(98D);
    }
}
