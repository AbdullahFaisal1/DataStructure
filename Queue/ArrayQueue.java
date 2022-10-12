package Queue;
public class ArrayQueue<T>{
    private int maxsize;
    private int size;
    private int head, tail;
    private T[] nodes;

    public ArrayQueue(int n){
        maxsize = n;
        size = 0;
        head = tail = 0;
        nodes = (T[]) new Object[n];
    }

    public boolean full(){
        return size == maxsize;
    }

    public int length(){
        return size;
    }

    public void enqueue(T e){
        nodes[tail] = e;
        tail = (tail+1) % maxsize;
        size++;
    }

    public T serve(){
        T val = nodes[head];
        head = (head+1) % maxsize;

        return val;
    }
}