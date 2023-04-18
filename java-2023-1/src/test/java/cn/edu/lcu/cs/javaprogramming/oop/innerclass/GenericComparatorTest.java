package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import cn.edu.lcu.cs.javaprogramming.collection.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericComparatorTest {

    @Test
    void compareEmployee() {
        GenericComparator<Employee> employeeComparator = new GenericComparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                return 0;
            }
        };
    }

    @Test
    void scoreComparator() {
        GenericComparator<Score> scoreComparator = new GenericComparator<Score>() {

            @Override
            public int compare(Score t1, Score t2) {
                return 0;
            }
        };


    }
}