package cn.edu.lcu.cs.designpattern.mediator.theory;

import java.util.HashSet;
import java.util.Set;

public class ConcreteMediator implements Mediator {
    private Set<Collegue> collegues = new HashSet<>();

    @Override
    public void register(Collegue collegue) {
        // 双向绑定
        collegues.add(collegue);
        collegue.setMediator(this);
    }

    @Override
    public void relay(Collegue sender) {
        collegues.stream().filter(c->!sender.equals(c)).forEach(Collegue::receive);
//        for (Collegue c : collegues) {
//            if (!collegue.equals(c)) { // 避免消息转发给最初的来源
//                c.receive();
//            }
//        }
    }
}
