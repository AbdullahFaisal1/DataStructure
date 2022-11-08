package HashTable;

public class HNode<T> {
    public int key;
    public T value;
    public HNode<T> next;

    public HNode(int key, T value){
        this.key = key;
        this.value = value;
        next = null;
    }
    public HNode(){
        next = null;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public HNode<T> getNext() {
        return next;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(HNode<T> next) {
        this.next = next;
    }

    
}
