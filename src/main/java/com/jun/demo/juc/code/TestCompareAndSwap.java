package com.jun.demo.juc.code;

/**
 * 模拟 CAS算法
 * @author Jun
 * @date: 19-10-25 上午11:18
 */
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectValue = compareAndSwap.get();
                boolean b = compareAndSwap.compareAndSet(expectValue, (int) (Math.random() * 100));
                System.out.println(b + " - "+ expectValue);
            }).start();
        }
    }
}

/**
 * 需要读写的内存值 V
 * 进行比较的值 A
 * 拟写入的新值 B
 * 当且仅当 V == A 时，进行 V = B ，否则，将不做任何操作
 */
class CompareAndSwap {
    private int value;

    public synchronized int get() {
        return this.value;
    }

    /**
     * 设置
     *
     * @param expectValue
     * @param newValue
     * @return
     */
    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }

    /**
     * 比较
     *
     * @param expectValue
     * @param newValue
     * @return
     */
    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
        }
        return oldValue;
    }

}
