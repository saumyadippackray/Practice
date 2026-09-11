package org.example.ComparatorExample;

public class ComparatorExampleArrayList implements Comparable<ComparatorExampleArrayList> {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComparatorExampleArrayList(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComparatorExampleArrayList{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(ComparatorExampleArrayList o) {
        if (this.age > o.age)
            return 1;
        else
            return -1;
    }

}
