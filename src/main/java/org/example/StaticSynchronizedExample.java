package org.example;
class SharedResource {
    // 모든 인스턴스에서 공유되는 count 변수
    private static int count = 0;

    // synchronized 제거 (동기화 없음)
    public static void increment() {
        for (int i = 0; i < 5; i++) { // 5번 증가
            count++;
            System.out.println(Thread.currentThread().getName() + " 증가 후 count: " + count);

            try {
                Thread.sleep(50); // 일부러 지연을 줘서 레이스 컨디션 발생 가능성 높임
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class StaticSynchronizedExample {
    public static void main(String[] args) {
        Runnable task = SharedResource::increment;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

