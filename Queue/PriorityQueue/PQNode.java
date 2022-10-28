package Queue.PriorityQueue;
public class PQNode<T>{
    public T data;
    public int priority;
    public PQNode<T> next;

    public PQNode(){
        next = null;
    }
    public PQNode(T e, int p){
        data = e;
        priority = p;
    }
}