package com.jun.demo.java8.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Jun
 * @date: 19-10-20 下午10:06
 */
public class TestLambda {

    @Test
    public void test() {
        Integer operation = operation(100, x -> x * x);
        System.out.println(operation);
        Student student = studentList.get(0);
        Supplier age = student::getAge;
    }

    Integer operation(Integer num, MyFun fun) {
        return fun.getValue(num);
    }

    @Test
    public void test2() {
        Collections.sort(studentList, (stu1, stu2) -> {
            if (stu1.getAge() == stu2.getAge()) {
                return stu1.getName().compareTo(stu2.getName());
            }
            return -Integer.compare(stu1.getAge(), stu2.getAge());
        });
        studentList.stream()
                .forEach(System.out::println);
    }

    private List<Student> studentList = Arrays.asList(
            new Student("zhangsan", 20, 0),
            new Student("lisi", 30, 0),
            new Student("wangwu", 40, 0),
            new Student("zhaoliu", 50, 0),
            new Student("zhaoliu", 60, 0)
    );
}
