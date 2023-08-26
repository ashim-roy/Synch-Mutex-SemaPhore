package syncmethod;

public class Count { // library class.
    private int value=0;  //private variable, other class cant access

    //other class can use methods.
    public synchronized void incrementValue(int offset){
        this.value +=offset;
    }

   public synchronized void decreament(int offset){
        this.value -=offset;
    }

    public synchronized int getValue(){
        return this.value;
    }
}