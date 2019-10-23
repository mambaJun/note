package com.jun.demo.java8.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Jun
 * @date: 19-10-22 下午3:10
 */
public class OptionTest {
    /*
        // 创建一个Optional 实例
        Optional.of();
        // 创建一个空的Optional 实例
        Optional.empty();
        // 若 t 不为 null，创建一个Optional实例，否则创建一个 空实例
        Optional.ofNullable(T t);
        Optional optional = Optional.of();
        // 是否包含值
        optional.isPresent();
        // 如果调用对象包含值，返回该值，否则返回 t
        optional.orElse(T t);
        // 如果调用对象包含值，返回该值，否则返回 supplier 获取的值
        optional.orElseGet(Supplier supplier);
        optional.orElseThrow();
        // 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
        optional.map(Function fun);
        // 与 map 类似，要求返回值必须是 Optional
        optional.flatMap(Function mapper);
*/
    @Test
    public void test() {
        Optional<Student> optional = Optional.ofNullable(null);

        Student student = optional.orElse(new Student());
        Student student1 = optional.orElseGet(() -> new Student());

        if (optional.isPresent()) {
            System.out.println("存在");
        }

        System.out.println(optional);
    }

    private List<Student> studentList = Arrays.asList(
            new Student("zhangsan", 20, 0),
            new Student("lisi", 30, 0),
            new Student("wangwu", 40, 0),
            new Student("zhaoliu", 50, 0),
            new Student("zhaoliu", 60, 0)
    );
}
