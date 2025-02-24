package org.example;

import java.util.concurrent.*;

class SumTask implements Callable<Integer>{
    private final int num;

    public SumTask(int num){
        this.num = num;
    }

    @Override
    public Integer call(){
        int sum = 0;
        for(int i =1; i <= num; i++){
            sum += i;
        }
        return sum;
    }
}
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> result = executor.submit(new SumTask(10));

        System.out.println("계산 중..");
        System.out.println("결과: "+ result.get());// 'get()'은 블로킹 호출

        executor.shutdown();
    }
}
