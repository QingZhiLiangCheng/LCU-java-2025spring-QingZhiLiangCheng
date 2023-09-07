package cn.edu.lcu.cs.designpattern.abstract_factory.wear;

public interface WearFactory {
    Suit buildSuit();

    Shirt buildShirt();

    Shoes buildShoes();
}
