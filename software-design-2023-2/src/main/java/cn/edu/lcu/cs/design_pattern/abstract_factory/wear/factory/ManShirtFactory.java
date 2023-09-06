package cn.edu.lcu.cs.design_pattern.abstract_factory.wear.factory;

public class ManShirtFactory implements ShirtFactory {
    @Override
    public Shirt buildShirt() {
        return new ManShirt(100D);
    }
}
