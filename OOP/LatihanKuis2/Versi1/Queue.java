import java.util.ArrayList;
import java.util.List;

public class Queue<T> implements IQueue<T>{
    protected List<T> queue;
    Queue(){
        this.queue = new ArrayList<T>();
    }

    public void enqueue(T object){
        this.queue.add(object);
    }
    
    public T dequeue(){
        if(this.queue.size()==0){
            throw new IndexOutOfBoundsException();
        }
        T result = this.queue.get(0);
        return result;
    }
}
