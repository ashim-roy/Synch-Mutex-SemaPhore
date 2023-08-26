package producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    //passing 2 constructor, store and threadname
    private Queue<Shirt> store;
    private String name;

    public Consumer(Queue<Shirt> store, String name) {
        this.store = store;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            if(store.size() > 0){
                store.remove();
                System.out.println(name + " consumed. Left shirt count " + store.size());
            }
        }
    }
}