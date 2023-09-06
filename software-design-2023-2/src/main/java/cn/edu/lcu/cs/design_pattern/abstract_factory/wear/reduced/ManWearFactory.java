package cn.edu.lcu.cs.design_pattern.abstract_factory.wear.reduced;

public class ManWearFactory implements WearFactory {
    @Override
    public Suit buildSuit() {
        return new ManSuit(100D);
    }

}
