package cn.edu.lcu.cs.design_pattern.mediator.relaymessage;

import java.util.HashSet;
import java.util.Set;

public class ConcreteMediator implements Mediator {
    private Set<Staff> staffs = new HashSet<>();

    @Override
    public void register(Staff staff) {
//        双向绑定
        staffs.add(staff);
        staff.setMediator(this);
    }

    @Override
    public void relay(Staff sender, String message) {
//        staffs.stream().filter(c->!c.equals(sender)).forEach(c -> c.receive(message));
        staffs.stream().filter(s->!s.equals(sender)).forEach(receiver->receiver.receive(sender, message));
    }

    @Override
    public void relay(Staff sender, Staff receiver, String message) {
        receiver.receive(sender, message);
    }

}
