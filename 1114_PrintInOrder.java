import java.util.concurrent.Semaphore;
class Foo {
    public Semaphore after_1 = new Semaphore(0);
    
    public Semaphore after_2 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        after_1.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        after_1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        after_2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        after_2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
// public class Foo {
//     //控制变量
//     private int flag = 0;
//     //定义Object对象为锁
//     private Object lock = new Object();
//     public Foo() {
//     }
//     public void first(Runnable printFirst) throws InterruptedException {
//         synchronized (lock){
//             //如果flag不为0则让first线程等待，while循环控制first线程如果不满住条件就一直在while代码块中，防止出现中途跳入，执行下面的代码，其余线程while循环同理
//             while( flag != 0){
//                 lock.wait();
//             }
//             // printFirst.run() outputs "first". Do not change or remove this line.
//             printFirst.run();
//             //定义成员变量为 1
//             flag = 1;
//             //唤醒其余所有的线程
//             lock.notifyAll();
//         }
//     }
//     public void second(Runnable printSecond) throws InterruptedException {
//         synchronized (lock){
//             //如果成员变量不为1则让二号等待
//             while (flag != 1){
//                 lock.wait();
//             }
//             // printSecond.run() outputs "second". Do not change or remove this line.
//             printSecond.run();
//             //如果成员变量为 1 ，则代表first线程刚执行完，所以执行second，并且改变成员变量为 2
//             flag = 2;
//             //唤醒其余所有的线程
//             lock.notifyAll();
//         }
//     }
//     public void third(Runnable printThird) throws InterruptedException {
//         synchronized (lock){
//             //如果flag不等于2 则一直处于等待的状态
//             while (flag != 2){
//                 lock.wait();
//             }
//             // printThird.run() outputs "third". Do not change or remove this line.
//             //如果成员变量为 2 ，则代表second线程刚执行完，所以执行third，并且改变成员变量为 0
//             printThird.run();
//             flag = 0;
//             lock.notifyAll();
//         }
//     }
// }
// public class Foo {
//     //声明两个 CountDownLatch变量
//     private CountDownLatch countDownLatch01;
//     private CountDownLatch countDownLatch02;

//     public Foo() {
//         //初始化每个CountDownLatch的值为1，表示有一个线程执行完后，执行等待的线程
//         countDownLatch01 = new CountDownLatch(1);
//         countDownLatch02 = new CountDownLatch(1);
//     }
//     public void first(Runnable printFirst) throws InterruptedException {
//             //当前只有first线程没有任何的阻碍，其余两个线程都处于等待阶段
//             // printFirst.run() outputs "first". Do not change or remove this line.
//             printFirst.run();
//             //直到CountDownLatch01里面计数为0才执行因调用该countDownCatch01.await()而等待的线程
//             countDownLatch01.countDown();
//     }
//     public void second(Runnable printSecond) throws InterruptedException {
//             //只有countDownLatch01为0才能通过，否则会一直阻塞
//             countDownLatch01.await();
//             // printSecond.run() outputs "second". Do not change or remove this line.
//             printSecond.run();
//             //直到CountDownLatch02里面计数为0才执行因调用该countDownCatch02.await()而等待的线程
//             countDownLatch02.countDown();
//     }
//     public void third(Runnable printThird) throws InterruptedException {
//             //只有countDownLatch02为0才能通过，否则会一直阻塞
//             countDownLatch02.await();
//             // printThird.run() outputs "third". Do not change or remove this line.
//             printThird.run();
//     }
// }