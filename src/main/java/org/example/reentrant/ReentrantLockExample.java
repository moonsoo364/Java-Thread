package org.example.reentrant;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource{
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + " 증가 후 count: "+count);
        }finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = resource::increment;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
