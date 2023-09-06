package cn.edu.lcu.cs.design_pattern.abstract_factory.wear;

public interface WearFactory {
    Suit buildSuit();

    Shirt buildShirt();

    Shoes buildShoes();
}
