package com.collections.Comparator;

import java.util.Arrays;
import java.util.Comparator;

interface CompareById<T extends Student> extends Comparator<T> {
    int compare(T o1, T o2);
}

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int group;
    private final int id;

    public int getId() {
        return id;
    }

    public Student(String name, int age, int group, int id) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.group != o.group) return this.group - o.group;
        if (this.name.compareTo(o.name) != 0) return this.name.compareTo(o.name);
        return this.age - o.age;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Student[] students = {new Student("Ivan", 17, 10, 5), new Student("Petr", 21, 13, 1), new Student("Ivan", 25, 10, 1)};
        Arrays.sort(students, Comparator.comparingInt(Student::getId));
        System.out.println(Arrays.toString(students));
    }
}
