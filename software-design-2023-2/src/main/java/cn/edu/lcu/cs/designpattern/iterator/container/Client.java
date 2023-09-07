package cn.edu.lcu.cs.designpattern.iterator.container;

public class Client {
    public static void main(String[] args) {
        Container<Person> persons = new ArrayContainer<>();
        initPersons(persons);
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p);
        }
        System.out.println("----------------------------------");
        iterator = persons.reverseIterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p);
        }

        System.out.println("*********************************");

        Container<Integer> numbers = new ArrayContainer<>();
        initNumbers(numbers);
        Iterator<Integer> numIterator = numbers.iterator();
        while (numIterator.hasNext()) {
            System.out.println(numIterator.next());
        }
        System.out.println("----------------------------------");
        numIterator = numbers.reverseIterator();
        while (numIterator.hasNext()) {
            System.out.println(numIterator.next());
        }

    }

    private static void initNumbers(Container<Integer> numbers) {
        int length = 5;
        for (int i = 0; i < length; i++) {
            numbers.add(i);
        }
    }

    private static void initPersons(Container<Person> persons) {
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
