package day1;

/**
 * 学生实体
 * @author: yianmou
 */
public class Student {
    private int age;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("yianmou");
        student1.print();
    }

    public void print() {
        System.out.println("yianmou=" + name);
    }
}


