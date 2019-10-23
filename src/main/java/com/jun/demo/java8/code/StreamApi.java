package com.jun.demo.java8.code;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jun
 * @date: 19-10-21 下午9:12
 */
public class StreamApi {
    @Test
    public void exercise() {
        List<Integer> squareList = Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(squareList);
        studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        Long count = studentList.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        Double avgDouble = studentList.stream()
                .collect(Collectors.averagingInt(Student::getAge));
        System.out.println(avgDouble);
        Integer sum = studentList.stream()
                .collect(Collectors.summingInt(Student::getAge));
        System.out.println(sum);
        Optional<Student> studentMax = studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge)));
        System.out.println(studentMax.isPresent());
        System.out.println(studentMax.get());
        Map<Integer, List<Student>> studentGroup = studentList.stream()
                .collect(Collectors.groupingBy(Student::getSex));
        System.out.println(JSONUtil.toJsonStr(studentGroup));
        System.out.println("多级分组");
        Map<Integer, Map<String, List<Student>>> mutilGroupStudent = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(
                        student -> {
                            if (student.getAge() > 25) {
                                return "中年";
                            }
                            return "青年";
                        }
                )));
        System.out.println(JSONUtil.toJsonStr(mutilGroupStudent));
        System.out.println("分区");
        Map<Boolean, List<Student>> partStudent = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getSex() == 0));
        System.out.println(JSONUtil.toJsonStr(partStudent));
        System.out.println("收集");
        IntSummaryStatistics summaryStudent = studentList.stream()
                .collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(summaryStudent);
    }

    @Test
    public void createStream() {

        // 1、通过 Collection 系列集合提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        // 2、通过Arrays 中的静态方法 stream() 获取数组流
        String[] strings = new String[16];
        Stream<String> stream1 = Arrays.stream(strings);
        // 3、通过 Stream 类中的静态方法 of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        // 4、创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
    }

    @Test
    public void test() {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        studentList.stream()
                .allMatch(student -> student.getAge() > 20); //
        studentList.stream()
                .anyMatch(student -> student.getAge() > 20); //
        studentList.stream()
                .noneMatch(student -> student.getAge() > 20); // 是否没有匹配所有元素（匹配所有元素）
        studentList.stream()
                .findAny();    //返回当前任一个
        studentList.stream()
                .findFirst();
        studentList.stream()
                .max(Comparator.comparingInt(Student::getAge));
        studentList.stream()
                .min(Comparator.comparingInt(Student::getAge));
        long count = studentList.stream()
                .map(Student::getName)
                .count();
    }

    private List<Student> studentList = Arrays.asList(
            new Student("zhangsan", 20, 0),
            new Student("zhangsan", 20, 1),
            new Student("lisi", 30, 0),
            new Student("lisi", 30, 1),
            new Student("wangwu", 40, 0),
            new Student("wangwu", 40, 1),
            new Student("zhaoliu", 50, 0),
            new Student("zhaoliu", 50, 1),
            new Student("zhaoliu", 60, 1),
            new Student("zhaoliu", 60, 0)
    );
}
