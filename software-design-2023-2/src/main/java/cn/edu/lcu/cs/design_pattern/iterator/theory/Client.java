package cn.edu.lcu.cs.design_pattern.iterator.theory;

public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("聊城大学");
        aggregate.add("北京大学");
        aggregate.add("济南大学");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(iterator.first());
    }
}
