package thread;

import java.util.concurrent.BlockingQueue;

public class MyThreadPoolExecutor {

    private int corePoolSize;

    private int maxPoolSize;

    private BlockingQueue<Runnable> blockingQueue;

    private volatile boolean shutDown = false;

    public MyThreadPoolExecutor(int corePoolSize, int maxPoolSize, BlockingQueue<Runnable> blockingQueue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.blockingQueue = blockingQueue;
    }

    public void execute(Runnable command){
        if (shutDown){
            return;
        }
        if (command == null){
            throw new NullPointerException("runnable task is not null");
        }
        if (corePoolSize < maxPoolSize){
            blockingQueue.offer(command);
            addWorker(command);
        }else {
            blockingQueue.offer(command);
        }
    }

    private void addWorker(Runnable command) {

        Thread thread = new Thread(new Worker());
        thread.start();
        corePoolSize++;
    }

    class Worker implements Runnable{

        @Override
        public void run() {
            while (!shutDown){
                Runnable task = blockingQueue.poll();
                if (task != null){
                    task.run();
                }
            }
        }
    }
}
