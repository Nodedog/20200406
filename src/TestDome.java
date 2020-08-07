

import java.util.Arrays;

/*
 *
 *               自定义类型进行比较
 *               implements         " Comparable "
 *
 *
 *
 * */
class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age < o.age) {
            return -1;
        }
        if(this.age == o.age) {
            return 0;
        }
        return 1;*/
        return this.age - o.age;
        //return this.score-o.score;
        //return this.name.compareTo(o.name);//字符串的比较大小
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }


}




public class TestDome {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("小明",10,89);
        students[1] = new Student("小光",18,99);
        students[2] = new Student("小徐",7,20);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }



    public static void main1(String[] args) {
        Integer[] array = {18,1,8,3,8,10};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

