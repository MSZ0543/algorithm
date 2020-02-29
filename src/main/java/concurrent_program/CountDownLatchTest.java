package concurrent_program;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-01-19 17:54
 **/
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }
        // 注意这里也是演示目的的逻辑，并不是推荐的协调方式
        while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }
        System.out.println("Wait for first batch finish");
        latch.countDown();
    }
}

class FirstBatchWorker implements Runnable {
    private CountDownLatch latch;

    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("First batch executed!");
        latch.countDown(); //将count值减1
    }
}

class SecondBatchWorker implements Runnable {
    private CountDownLatch latch;

    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
//            latch.await(); //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            latch.await(1, TimeUnit.MICROSECONDS); //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
            System.out.println("Second batch executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
