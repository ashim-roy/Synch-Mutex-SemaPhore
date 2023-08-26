package addsubtractmutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.value = 0;
        Lock lock  = new ReentrantLock(); // creating lock here

        //pass the lock
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

// i will create a executer service and pass my adder and subtractor.
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.MINUTES);

        System.out.println("FINAL VALUE IS- " + count.value);

    }
}