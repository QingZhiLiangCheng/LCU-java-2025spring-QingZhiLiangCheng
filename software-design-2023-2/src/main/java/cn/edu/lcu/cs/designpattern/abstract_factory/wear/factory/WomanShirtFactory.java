package cn.edu.lcu.cs.designpattern.abstract_factory.wear.factory;

public class WomanShirtFactory implements ShirtFactory {
    @Override
    public Shirt buildShirt() {
        return new WomanShirt(100D);
    }
}
