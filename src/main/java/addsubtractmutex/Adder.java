package addsubtractmutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;
    private Lock lock;

    public Adder(Count count, Lock lock) {

        this.count = count;
        //let me initilize
        this.lock = lock;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 10000; ++i) {

            System.out.println("adder is TAKING LOCK" + Thread.currentThread().getName());
            lock.lock();
            count.value += i; // CRITICAL SECTION
            System.out.println("adder is releasing LOCK");
            lock.unlock();
        }
    }
}