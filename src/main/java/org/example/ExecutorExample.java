package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{

    private final int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 실행 중 - 작업 ID: " + taskId);
        try {
            Thread.sleep(1000); // 작업 시뮬레이션
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 완료 - 작업 ID: " + taskId);
    }

}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i <= 5; i++){
            executor.execute(new Task(i));
        }

        executor.shutdown();
    }
}
