package addsubtractmutex;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;
    public Subtractor(Count count, Lock lock) {

        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; ++i) {
            System.out.println("subtractor is taking LOCK" + Thread.currentThread().getName());
            //taking a lock
            lock.lock();
            this.count.value -= i; // CRITICAL SECTION
            //my critical section is over, release the lock
            System.out.println("sub releasing lock");
            lock.unlock();
        }
    }
}