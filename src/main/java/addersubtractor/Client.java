package addersubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        //count.value = 0;

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
// i will create a executer service and pass my adder and subtractor.
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.MINUTES);

        System.out.println("FINAL VALUE IS- " + count.value);
    }
}