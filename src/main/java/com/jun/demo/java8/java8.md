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