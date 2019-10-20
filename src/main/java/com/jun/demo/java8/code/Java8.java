package com.jun.demo.java8.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jun
 * @date: 19-10-20 下午7:00
 */
public class Java8 {


    @Test
    public void test1() {
//        studentList.stream()
//                .filter((student) -> student.getAge() > 30)
//                .limit(1)
//                .forEach(System.out::println);
        studentList.stream()
                .map(Student::getName)
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
