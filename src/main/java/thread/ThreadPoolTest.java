package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

        MyThreadPoolExecutor executor1 = new MyThreadPoolExecutor(5, 10, new LinkedBlockingDeque<Runnable>());

        for (int i=0; i<20; i++){
            MyWorkQueue queue = new MyWorkQueue(i);
            //executor.execute(queue);
            executor1.execute(queue);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    static class MyWorkQueue implements Runnable {

        private int num;

        public MyWorkQueue(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("当前线程-" + Thread.currentThread().getName() + "num=" + num);
            try {
                num++;
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程-" + Thread.currentThread().getName() + "执行完毕,num=" + num);
        }
    }
}
