package Queue;

public class Queue<T> {

    private Qnode<T> front;
    private Qnode<T> rear;
    private int size;
    private int maxSize;

    public Queue(){
        front = rear = null;
        size = 0;
    }

    public boolean empty(){
        return size <= 0;
    }

    public void enqueue(T e) {
        Qnode<T> temp = new Qnode<>(e);
        if(rear == null){
            front = rear = temp;
        }else{
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    public T dequeue() {
        T val = front.data;
        front = front.next;
        size--;
        if(size == 0)
            rear = null;
        return val;
    }

    public int length() {
        return size;
    }

    public boolean Isfull() {
        return size == maxSize;
    }
    

    public void printQueue(){
        for(int i=0; i<length(); i++){
            T val = dequeue();
            System.out.print(val + " ");
            enqueue(val);
        }
        System.out.println();
    }

    public T top(){
        return front.data;
    }

    
}

