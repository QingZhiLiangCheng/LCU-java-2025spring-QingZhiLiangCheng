package cn.edu.lcu.cs.designpattern.abstract_factory.wear.reduced;

public class WomanWearFactory implements WearFactory {
    @Override
    public Suit buildSuit() {
        return new WomanSuit(100D);
    }

}
