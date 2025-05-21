package cn.edu.lcu.cs.javaprogramming.oop.animal;

class Animal {
    public Animal() {  
        System.out.print("Animal构造方法: ");  
        makeSound();  
    }  
    public void makeSound() {  
        System.out.println("动物发出声音");  
    }  
}  

class Dog extends Animal {  
    private String sound = "汪汪";  

    public Dog() {  
        super();  
        System.out.print("Dog构造方法: ");  
        makeSound();  
    }  

    @Override  
    public void makeSound() {  
        System.out.println(sound);  
    }  
}  

public class AnimalTest {
    public static void main(String[] args) {  
        new Dog();  
    }  
}