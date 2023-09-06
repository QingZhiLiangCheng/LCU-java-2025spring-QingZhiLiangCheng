package cn.edu.lcu.cs.design_pattern.iterator.iterable;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate<Person> persons = new ConcreteAggregate<>();
        initPersons(persons);
        Iterator<Person> iterator = persons.iterator();
        // 传统的迭代器遍历方式
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------");
        // ConcreteAggregate（persons）实现了Iterable接口，可以使用foreach语法遍历
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("----------------------------------");
        // ConcreteAggregate（persons）实现了Iterable接口，也可以调用forEach方法
        persons.forEach(System.out::println);

        System.out.println("*********************************");

        Aggregate<Integer> numbers = new ConcreteAggregate<>();
        initNumbers(numbers);
        Iterator<Integer> numIterator = numbers.iterator();
        while (numIterator.hasNext()) {
            System.out.println(numIterator.next());
        }
        System.out.println("----------------------------------");
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }

    private static void initNumbers(Aggregate<Integer> numbers) {
        int length = 5;
        for (int i = 0; i < length; i++) {
            numbers.add(i);
        }
    }

    private static void initPersons(Aggregate<Person> persons) {
        int length = 5;

        for (int i = 0; i < length; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("person" + i);
            person.setHeight(i);
            persons.add(person);
        }
    }
}
