package concurrent_program;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-01-20 10:20
 **/
public class PhaserTest {


    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser();
        Worker[] workers = new Worker[5];
        for (int i = 0; i < workers.length; i++) {
            // 创建五个工人对象，并且通过register()方法将他们注册到phaser。五个线程，phaser的每个阶段
            // （调用arriveAndAwaitAdvance()方法的地方）都要等待五个线程执行完才能继续执行下去
            workers[i] = new Worker(myPhaser);
            myPhaser.register();
        }
        Thread threads[] = new Thread[workers.length];
        for (int i = 0; i < workers.length; i++) {
            threads[i] = new Thread(workers[i], "Workers" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main:The phaser has finished:%s.\n", myPhaser.isTerminated());
    }

    public static String threadName() {
        return Thread.currentThread().getName();
    }

    static class Worker implements Runnable {
        private Phaser phaser;

        public Worker(Phaser phaser) {
            super();
            this.phaser = phaser;
        }

        @Override
        public void run() {
            //将每个工人到达工厂的信息打印出来
            System.out.printf("%s: Has arrived to do the company. %s---------00000000000000000000\n", Thread.currentThread().getName(), new Date());
            //等待所有的线程执行到这里，各个线程才会开始向下执行，不过在向下执行之前会执行phaser的onAdvance()方法
            phaser.arriveAndAwaitAdvance();

            System.out.printf("%s :Is going to do the frist step.%s******************0\n", Thread.currentThread().getName(), new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Has done the frist step. %s\n", Thread.currentThread().getName(), new Date());
            phaser.arriveAndAwaitAdvance();


            System.out.printf("%s :Is going to do the second step.%s---------1111111111111111111\n", Thread.currentThread().getName(), new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Has done the second step. %s*****************1\n", Thread.currentThread().getName(), new Date());
            phaser.arriveAndAwaitAdvance();


            System.out.printf("%s :Is going to do the thrid step.%s---------222222222222222222\n", Thread.currentThread().getName(), new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Has done the thrid step. %s******************2\n", Thread.currentThread().getName(), new Date());
            phaser.arriveAndAwaitAdvance();
        }

    }

    static class MyPhaser extends Phaser {

        /**
         * 重写onAdvance(int x,int y)方法
         * 在Phaser类中，onAdvance(int x,int y)方法在Phaser阶段改变的时候会自动执行，
         * x表示当前的阶段数，y表示注册的参与者数量
         * 如果onAdvance(int x,int y)方法返回false表示phaser在继续执行，返回true表示phaser已经完成执行并且进入了终止态
         */
        @Override
        public boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    return workersArrived();
                case 1:
                    return finishFristJob();
                case 2:
                    return finishSecondJob();
                case 3:
                    return finishJob();
                default:
                    return true;
            }
        }

        /**
         * workersArrived:返回false，表明phaser已经开始执行
         *
         * @return boolean
         * @author JM
         * 2017-2-27 下午9:53:39
         */
        private boolean workersArrived() {
            System.out.printf("Phaser: The job are going to start. The workers are ready.\n");
            //getRegisteredParties()返回的是注册的线程数
            System.out.printf("We have %d workers.\n", getRegisteredParties());
            return false;
        }

        /**
         * finishFristExercise:表示完成了第一阶段的工序
         *
         * @return boolean
         * @author JM
         * 2017-2-27 下午10:08:04
         */
        private boolean finishFristJob() {
            System.out.printf("Phaser: All the workers have finished the first step.\n");
            System.out.printf("Phaser: It's time to second step.\n");
            return false;
        }

        /**
         * finishFristExercise:表示完成了第二阶段的工序
         *
         * @return boolean
         * @author JM
         * 2017-2-27 下午10:08:04
         */
        private boolean finishSecondJob() {
            System.out.printf("Phaser: All the workers have finished the second step.\n");
            System.out.printf("Phaser: It's time to third step.\n");
            return false;
        }

        /**
         * finishFristExercise:表示完成了第二阶段的工序
         *
         * @return boolean
         * @author JM
         * 2017-2-27 下午10:08:04
         */
        private boolean finishJob() {
            System.out.printf("Phaser: All the workers have finished the job.\n");
            System.out.printf("Phaser: Thank you for your time.\n");
            return true;
        }
    }

}
