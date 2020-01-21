package concurrent_program;

import java.util.concurrent.Semaphore;

/**
 * @program: algorithm
 * @description: 多个线程交替打印ABC
 * @author: szm
 * @create: 2020-01-21 15:51
 **/
public class PrintABC {

    private static Integer num = 0;


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        Thread t1 = new Thread(new Thread1(semaphoreA, semaphoreB));
        Thread t2 = new Thread(new Thread2(semaphoreB, semaphoreC));
        Thread t3 = new Thread(new Thread3(semaphoreA, semaphoreC));
        t1.start();
        t2.start();
        t3.start();
    }

    static class Thread1 implements Runnable {
        private Semaphore semaphoreA;
        private Semaphore semaphoreB;

        public Thread1(Semaphore semaphoreA, Semaphore semaphoreB) {
            this.semaphoreA = semaphoreA;
            this.semaphoreB = semaphoreB;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreA.acquire();
                    System.out.println("A--" + num ++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreB.release();
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        private Semaphore semaphoreB;
        private Semaphore semaphoreC;

        public Thread2(Semaphore semaphoreB, Semaphore semaphoreC) {
            this.semaphoreB = semaphoreB;
            this.semaphoreC = semaphoreC;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B--" + num ++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreC.release();
                }
            }
        }
    }

    static class Thread3 implements Runnable {
        private Semaphore semaphoreA;
        private Semaphore semaphoreC;

        public Thread3(Semaphore semaphoreA, Semaphore semaphoreC) {
            this.semaphoreA = semaphoreA;
            this.semaphoreC = semaphoreC;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.println("C--" + num ++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreA.release();
                }
            }
        }
    }
}




