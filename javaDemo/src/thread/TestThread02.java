package thread;
/**
 * 项目中的线程安全问题？
 * 1)什么是线程安全？
 * 多线程在共享数据集上执行时，数据状态以及值始终是一致。
 * 2)什么是线程不安全？
 * 多线程在共享数据集上执行时，数据状态以及值出现了不一致的状态。
 * 例如：
 * 1)多个线程执行售票操作，出现了相同值或负数现象。
 * 2)多个线程操作同一个日期，最后转换的结果不一致。
 * 
 * 3)出现线程不安全的原因？
 * a)多个线程并发执行
 * b)多个线程存在资源共享(共享数据集)
 * c)多个线程在共享数据集上的操作不是原子操作。
 * 
 * 4)如何保证线程安全？
 * a)取消共享(但并不是所有场景都能取消共享)
 * b)加锁(同步方法，同步代码块):会影响性能,优化方向(局部加锁)
 * c)CAS(比较和交换) ：参考AtomicLong
 */

public class TestThread02 {

}
