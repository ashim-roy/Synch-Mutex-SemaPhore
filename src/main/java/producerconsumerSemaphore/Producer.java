package producerconsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSizeOfStore;
    private String name;
//define semaphores here
    private Semaphore semaphoreForProducer;
    private Semaphore semaphoreForConsumer;
    public Producer(Queue<Shirt> store, int maxSizeOfStore, String name,
                    Semaphore semaphoreForProducer, Semaphore semaphoreForConsumer) {

        this.store = store;
        this.maxSizeOfStore = maxSizeOfStore;
        this.name = name;
        //i will now initialize
        this.semaphoreForProducer = semaphoreForProducer;
        this.semaphoreForConsumer = semaphoreForConsumer;
    }

    @Override
    public void run() {
        while(true){
            //if(store.size() < maxSizeOfStore){     //if not needed anymore
            try {
                semaphoreForProducer.acquire();    // decrementing producer
                store.add(new Shirt());
                System.out.println(name + " produced. Left shirt count " + store.size());
                semaphoreForConsumer.release(); // incrementing consumer

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}