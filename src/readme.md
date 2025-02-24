# 자바의 멀티쓰레드 클래스
## Runnable과 Thread 
Java에서 멀티 쓰레딩을 구현하는 방법에는 크게 2가지가 있다.
1. Runnable 인터페이스를 구현
2. Thread 클래스를 상속

Runnable은 다른 클래스도 상속 가능하기 때문에 유연성이 높다.
## synchnoized
`synchronized`는 여러 개의 쓰레드가 공유 자원에 동시에 접근하는 것을 방지하여 데이터의 일관성을 유지하는 데 사용된다.
여러 쓰레드에서 하나의 자원에 동시에 접근하려고하면 경쟁조건(Race Condition)이 발생하기 때문에 동기화가 필요하다.
### `syncnronized` 사용 범위
1. `synchronized` 메서드 : 전체 메서드에 동기화 적용
2. `synchronized` 블록 : 특정 코드 블록만 동기화
3. `static synchronized` : 클래스 단위 동기화

### `synchronized` 사용 시 주의할 점

__단점__
- 동기화는 성능 저하를 초래할 수 있음(`synchronized`가 걸린 코드는 한 번에 하나의 스레드만 접근 가능하므로 병렬 처리 감소). 

__대안__
- `ReentrantLock`을 사용하여 유연한 동기화 적용 가능.
- `Concurrent` 패키지를 활용하여 성능 최적화 가능

## `java.util.concurrent` 패키지 예제
java.util.concurrent 패키지는 Java 5부터 제공되는 동시성(Concurrency) 관련 유틸리티로, synchronized 보다 성능이 뛰어나고 유연한 방식으로 멀티스레딩을 제어할 수 있도록 도와준다.
### `ExecutorService` (스레드 풀)
`ExecutorService`를 사용하면 직접 `Thread`객체를 생성하지 않고, 스레드 풀을 관리하면서 스레드를 효율적으로 사용할 수 있다.
### `Callable`과 `Future`(반환값 있는 비동기 실행)
`Runnable`은 반환값이 없지만 `Callable`은 결과 값을 반환할 수 있음
__장점__
1. `Callable`을 사용하면 작업의 결과를 반환할 수 있음.
2. `Future.get()`을 호출하면 결과를 가져올 수 있으며, 해당 스레드가 완료될 때까지 기다림(블로킹 발생).

### ReentrantLock(더 유연한 동기화)
`synchronized` 보다 더 정교한 제어가 가능하면, 락을 재진입할 수 있음.

### ConcurrentHashMap (멀티스레드 안전한 HashMap)
`HashMap`은 멀티스레드 환경에서 충돌이 발생하지만 `ConcurrentHashMap`은 동기화 문제를 해결해줌