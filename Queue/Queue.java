package Queue;
class Node<T>{
    public T data;
    public Node<T> next;
    public Node(){
        data = null;
        next = null;
    }

    public Node(T val){
        data = val;
        next = null;
    }
}
public class Queue<T> {

    private Node<T> front, rear;
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
        Node<T> temp = new Node<>(e);
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

