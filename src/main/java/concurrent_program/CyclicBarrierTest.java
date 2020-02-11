package concurrent_program;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-01-19 18:04
 **/
public class CyclicBarrierTest {

    /*
         看下API
           CyclicBarrier有两个构造函数

            public CyclicBarrier(int parties)
            public CyclicBarrier(int parties, Runnable barrierAction)
            第一个参数，表示那个一起执行的线程个数。
            第二个参数，表示线程都处于barrier时，一起执行之前，先执行的一个线程。

            让线程处于barrier状态的方法await()

            public int await()
            public int await(long timeout, TimeUnit unit)
            第一个默认方法，表示要等到所有的线程都处于barrier状态，才一起执行
            第二个方法，指定了等待的时间，当所有线程没有都处于barrier状态，又到了指定的时间，所在的线程就继续执行了。
*/
    private static int res = 0;

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier barrier;

        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Executed!");
                    synchronized (this) {
                        res ++;
                        System.out.println(res);
                    }
                    barrier.await();
                }
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
