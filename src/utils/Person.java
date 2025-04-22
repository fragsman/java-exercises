package utils;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int weight;
    private Sex sex;

    public enum Sex{
        MALE,
        FEMALE
    }

    public Person(String name, int age, int weight, Sex sex) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }

    public void printPerson(){
        System.out.println("Name: "+name+", age: "+age+", weight: "+weight+", sex: "+sex);
    }

    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
