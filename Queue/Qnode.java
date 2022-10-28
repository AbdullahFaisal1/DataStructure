package Queue;

public class Qnode<T>{
    public T data;
    public Qnode<T> next;

    public Qnode(){
        data = null;
        next = null;
    }

    public Qnode(T val){
        data = val;
        next = null;
    }
}
