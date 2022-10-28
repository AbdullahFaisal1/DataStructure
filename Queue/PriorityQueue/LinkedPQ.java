package Queue.PriorityQueue;
public class LinkedPQ<T> {
    private int size;
    private PQNode<T> head;

    public LinkedPQ(){
        size = 0;
        head = null;
    }

    public int length(){
        return size;
    }

    public boolean full(){
        return false;
    }

    public void enqueue(T e, int pty){
        PQNode<T> tmp = new PQNode<T>(e, pty);
        if((size == 0) || (pty > head.priority)){
            tmp.next = head;
            head = tmp;
        }else{
            PQNode<T> curr = head;
            PQNode<T> pre = null;
            while( (curr != null) && (pty < curr.priority) ){
                pre = curr;
                curr = curr.next;
            }
            if(curr == null){
                tmp.next = null;
                pre.next = tmp;
            }else{
                tmp.next = curr;
                pre.next = tmp;
            }
            
        }
        size++;
    }

    public PQElement<T> serve(){
        PQNode<T> node = head;
        PQElement<T> pqe = new PQElement<T>(node.data, node.priority);
        head = head.next;
        size--;
        return pqe;
    }

    public void print(){
        for(int i=0; i<size; i++){
            PQElement<T> val = serve();
            System.out.print(val + " --> ");
            enqueue((T)val.data, val.priority);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedPQ<Integer> list = new LinkedPQ<>();
        list.enqueue(1, 1);
        list.enqueue(2, 10);
        list.enqueue(3, 11);
        list.enqueue(4, 3);

        list.print();

    }
}

class PQElement<T>{
    public T data;
    public int priority;
    public PQElement(T e, int priority){
        data = e;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return "PQElement [data=" + data + ", priority=" + priority + "]";
    }
    
}
