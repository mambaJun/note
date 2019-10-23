# Java8 学习
- 
    /**
     * Java8 四大核心接口
     *     Consumer<T>; 消费接口
     *          void accept(T t)
     *          
     *     Supplier<T>;供给接口
     *          T get();
     *     Function<T, R>;函数型接口
     *          R apply(T t);
     *          
     *     Predicate<T>;断言型接口
     *          boolean test(T t );
     *
- @FunctionalInterface：函数接口检查
    该类只有一个抽象方法
##  六、方法引用与构造器引用
- 方法引用的三种主要格式：
    - 对象::实例方法名
        System.out::println()
    - 类::静态方法名
    - 类::实例方法名
- 构造器引用
格式：
    - ClassName::new
   
   
   
## 七、Stream API
流 到底是什么？ 
    是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列
    集合 - 数据
    流 - 计算
- 1、Stream不会自己储存元素
- 2、Stream不会改变对象。相反，他们会返回一个持有结果的新Stream
- Stream操作是延迟执行的。意味着他们会等到需要结果时才执行

## 八、Option 
Optional 常用方法：
```java
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
```

## 九、接口中的默认方法 和 静态方法
```text
接口默认方法的“类优先”原则
若一个接口定义了一个默认方法，而另一个父类 或 接口中又定义一个同名的方法时
- 选择父类中的方法，如果一个父类提供了具体的实现，那么接口中具有相同名称 和参数的默认方法会被忽略
- 多个接口冲突。如果一个父类提供一个默认方法，而另一个接口也提供一个具有相同名称 和 参数列表的方法（不管方法是不是默认方法），
那么必须覆盖该方法来解决冲突
    小结：1、父类优先，只要和父类冲突，接口服从父类
         2、接口之间冲突，明确重写的方法来自哪个接口 
```

## 十、新时间日期 API
```java
    LocalDate;
    LocalTime;
    LocalDateTime;
    Instant：时间戳
    Duration：计算两个时间之间的间隔
    Period：计算两个日期之间的间隔
```
