package org.example;
class BankAccount{
    private int balance = 100;


    public synchronized void withdraw(int amount){
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " 출금: "+ amount);
            balance -= amount;
            //synchronized가 없으면 thread2에서 -40으로 출력됨
            System.out.println("잔액: "+ balance);
        }else{
            System.out.println(Thread.currentThread().getName()+ " 출금 실패! 잔액 부족");
        }
    }
}
public class SynchronizedExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(70),"Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(70),"Thread-2");

        t1.start();;
        t2.start();
    }
}
