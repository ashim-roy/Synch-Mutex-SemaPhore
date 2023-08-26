package syncmethod;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
// passing count variable here and there
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.getValue());
    }
}