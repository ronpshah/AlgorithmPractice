package crackingcodeinterview.stackqueue;

import java.util.LinkedList;

/**
 * Created by shah_ on 6/19/2016.
 */

class Animal{
    private int order;
    private String name;

    public Animal(String n){
        name = n;
    }
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.order;
    }
}
public class AnimalQueue {

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;

        if (a instanceof Dog)
            dogs.addLast((Dog) a);
        else if (a instanceof Cat)
            cats.addLast((Cat) a);
    }

    public Animal dequeueAny(){
        if (dogs.size() == 0){
            return dequeueCat();
        }else if (cats.size() == 0){
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)){
            return dogs.poll();
        }else{
            return cats.poll();
        }
    }

    public Cat dequeueCat(){
        return cats.poll();
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    public static void main(String[] args) {
        AnimalQueue AQ = new AnimalQueue();
        Dog D1 = new Dog("D1");
        Dog D2 = new Dog("D2");

        AQ.enqueue(D1);
        AQ.enqueue(D2);

        Cat C1 = new Cat("C1");
        Cat C2 = new Cat("C2");

        AQ.enqueue(C1);
        AQ.enqueue(C2);

        Dog D3 = new Dog("D3");

        AQ.enqueue(D3);
        Cat C3 = new Cat("C3");

        AQ.enqueue(C3);

        System.out.println(AQ.dequeueAny().getName());
        System.out.println(AQ.dequeueAny().getName());
        System.out.println(AQ.dequeueAny().getName());

        System.out.println(AQ.dequeueDog().getName());
        System.out.println(AQ.dequeueAny().getName());
        System.out.println(AQ.dequeueAny().getName());
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}

class Cat extends Animal{
    public Cat(String c){
        super(c);
    }
}
