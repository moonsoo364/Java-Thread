package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 멀티스레드 환경에서 동시 접근
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                map.put("A", map.getOrDefault("A", 0) + 1);
                System.out.println(Thread.currentThread().getName() + " A: " + map.get("A"));
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                map.put("B", map.getOrDefault("B", 0) + 1);
                System.out.println(Thread.currentThread().getName() + " B: " + map.get("B"));
            }
        };

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();
    }
}


