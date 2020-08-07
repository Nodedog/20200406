/*
*
*                                   自定义类的克隆
*                               implements    “Cloneable”
*
* 面试问题： Cloneable为什么是一个空接口？
* 如果一个类实现了Cloneable 接口代表这个类可以被克隆
*
*
*
*
*  1.Animal类要实现Cloneable的接口
* 2.在Animal类中 重写 toString 方法
* 3.在Animal类中 重写Object clone的方法
* 4.Animal animal1 = (Animal) animal.clone();定义一个 animal1 来接受新克隆的
* 同时clone的 是一个 Object类 所以要强转成（animal）
* 5.Animal animal1 = (Animal) animal.clone();里的clone 还会报错
* Alt+enter 两个 方法都可以用 1.抛出异常 2.try catch 捕获异常
*
*
* */
class Value implements Cloneable{
    public int value = 10;

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Animal implements Cloneable{
    public int age;
    public Value value1;//引用

    public Animal(int age) {
        this.age = age;
        value1 = new Value();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }


    //浅拷贝
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/



    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal animal = (Animal) super.clone();
        animal.value1 = (Value) animal.value1.clone();
        return animal;
    }
}



public class TestDome2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal(10);
        Animal animal1 = (Animal) animal.clone();
        System.out.println(animal.value1.value);
        System.out.println(animal1.value1.value);

        animal1.value1.value = 9;
        System.out.println(animal.value1.value);
        System.out.println(animal1.value1.value);



   /* public static void main1(String[] args) throws CloneNotSupportedException {
    Animal animal = new Animal(10);
        Animal animal1 = (Animal) animal.clone();
        try {
            Animal animal1 = (Animal) animal.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(animal.age);
        System.out.println(animal1.age);

        animal.age = 999;
        System.out.println(animal.age);
        System.out.println(animal1.age)*/;
    }
}
