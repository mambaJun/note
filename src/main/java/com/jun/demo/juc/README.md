# JUC
## 一、Java JUC简介
## 二、volatile 关键字 - 内存可见性（数据共享没有延迟）
    当多个线程进行操作共享时，可以保证内存中的数据可见。
    相比于 synchronize 是一种 轻量级的同步策略
    理解：
        原来是每个线程都会将 主存 中 的数据缓存到自己线程用进行操作然后刷新到主存中，
        使用volatile就可以简单的看成各个线程不缓存，而是直接对主存里的数据直接进行操作，从而保证了各个线程之间对共享数据的可见性
    注意点：
        1、volatile 不具备互斥性 （相比于 synchronize）
        2、volatile 不能保证变量的“原子性”（原子性：数据的不可拆分）
            
## 三、原子变量 -CAS 算法
    原子变量：jdk1.5 后[jdk1.5 后java.util.concurrent.atomic](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html) 包下提供常用的原子变量
    - 1.volatile 保证 内存可见性
    - 2.CAS (Compare-And-Swap)算法保证数据的原子性
```text
        CAS 算法 是 硬件对于 并发操作共享数据的支持
        CAS 包含三个操作数
            需要读写的内存值   内存值 V
            进行比较的值      预估值 A
            拟写入的新值      更新值 B
            当且仅当 V == A 时，进行 V = B ，否则，将不做任何操作
```
        
## 四、ConcurrentHashMap 锁分段机制
- [](./image/ConcurrentHashMap.png)
- CopyOnWriteArrayList/CopyOnWriteArraySet
    注意：
        添加操作多时，效率低。因为每次添加都会进行复制，开销非常大。并发迭代操作多少可以选择。
## 五、CountDownLatch闭锁
## 六、实现Callable 接口
## 七、Lock同步锁
## 八、Condition 控制线程通信
## 九、线程八锁
## 十、线程按序交换
## 十一、ReadWriteLock 读写锁
## 十二、线程池
##　十三、线程调度
## 十四、ForkJoinPool 分支、合并 框架工作窃取