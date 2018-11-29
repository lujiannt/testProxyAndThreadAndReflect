package lock01;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock基础使用
 */
public class TestLock01 {
    private Lock lock = new ReentrantLock();

    /**
     * 测试synchronized
     */
    @Test
    public void test1() {
        new Thread(() -> {
            testLock1("A");
        }).start();
        new Thread(() -> {
            testLock1("B");
        }).start();
    }

    /**
     * 测试lock方法
     */
    @Test
    public void test2() {
        new Thread(() -> {
            testLock2("A");
        }).start();
        new Thread(() -> {
            testLock2("B");
        }).start();
    }

    /**
     * 测试tryLock方法
     */
    @Test
    public void test3() {
        new Thread(() -> {
            testLock3("A");
        }).start();
        new Thread(() -> {
            testLock3("B");
        }).start();
    }

    /**
     * 测试lockInterruptibly方法
     */
    @Test
    public void test4() {
        Thread t1 = new Thread(() -> {
            testLock4("A");
        });


        Thread t2 = new Thread(() -> {
            testLock4("B");
        });
        t1.start();
        t2.start();
        //中断线程1，会释放锁,此时线程2会获得锁
        t1.interrupt();

    }

    /**
     * java虚拟机中synchronized关键字，悲观锁，强制同步
     * @param name
     */
    private synchronized void testLock1(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.println("name=" + name
                    + (" " + (i + 1)));
        }
    }

    /**
     * 悲观锁，强制同步
     * @param name
     */
    private void testLock2(String name) {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("name=" + name
                    + (" " + (i + 1)));
        }
        lock.unlock();
    }

    /**
     * 尝试获取锁，成功返回true
     * @param name
     */
    private void testLock3(String name) {
        if (lock.tryLock()) {
            for (int i = 0; i < 5; i++) {
                System.out.println("name=" + name
                        + (" " + (i + 1)));
            }
        }
//        lock.unlock();
    }

    /**
     * 可中断锁，强制同步堵塞，但可以接受中断请求
     * @param name
     */
    private void testLock4(String name) {
        try {
            lock.lockInterruptibly();
            System.out.println(name + "拿到锁");
        } catch (InterruptedException e) {
            System.out.println(name + "中断锁");
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("name=" + name
                    + (" " + (i + 1)));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        lock.unlock();
    }
}
