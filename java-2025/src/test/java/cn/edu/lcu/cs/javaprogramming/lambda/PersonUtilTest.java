package cn.edu.lcu.cs.javaprogramming.lambda;

import cn.edu.lcu.cs.javaprogramming.lambda.Person;
import cn.edu.lcu.cs.javaprogramming.lambda.PersonUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonUtilTest {

    // 假设 PersonUtil 类中有一个静态方法：
    // public static boolean checkAndExecute(Person person, Predicate<Person> condition, Consumer<Person> action)

    @Test
    void testCheckAndExecute_personIsNull_shouldReturnFalseAndNotExecuteAction() {
        // Arrange
        Person person = null;
        Predicate<Person> condition = p -> true;
        Consumer<Person> action = p -> {};

        // Act
        boolean result = PersonUtil.checkAndExecute(person, condition, action);

        // Assert
        assertFalse(result);
    }

    @Test
    void testCheckAndExecute_conditionReturnsFalse_shouldReturnFalseAndNotExecuteAction() {
        // Arrange
        Person mockPerson = mock(Person.class);
        Predicate<Person> condition = p -> false;
        Consumer<Person> action = mock(Consumer.class);

        // Act
        boolean result = PersonUtil.checkAndExecute(mockPerson, condition, action);

        // Assert
        assertFalse(result);
        verify(action, never()).accept(any());
    }

    @Test
    void testCheckAndExecute_conditionReturnsTrue_shouldReturnTrueAndExecuteAction() {
        // Arrange
        Person mockPerson = mock(Person.class);
        Predicate<Person> condition = p -> true;
        Consumer<Person> action = mock(Consumer.class);

        // Act
        boolean result = PersonUtil.checkAndExecute(mockPerson, condition, action);

        // Assert
        assertTrue(result);
        verify(action, times(1)).accept(eq(mockPerson));
    }
}
