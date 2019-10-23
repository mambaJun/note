package com.jun.demo.java8.code;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Jun
 * @date: 19-10-20 下午7:42
 */
@ToString
public class Student {
    private String name;
    private Integer age;
    private Integer sex;

    public Student() {
    }

    public Student(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
