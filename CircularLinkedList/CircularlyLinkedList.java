package CircularLinkedList;
public class CircularlyLinkedList<E> {
    private CNode<E> tail;
    private int size;

    public CircularlyLinkedList() {
        tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new CNode<E>(e, null);
            tail.setNext(tail);
        } else {
            CNode<E> newNode = new CNode<E>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        CNode<E> temp = tail.getNext();
        if (size == 1) {
            tail = null;
        } else {
            tail.setNext(tail.getNext().getNext());
        }

        size--;
        return temp.getElement();
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }else{
            CNode<E> temp = tail.getNext();
            E val = tail.getElement();
            for(int i=0; i<size-1; i++){
                temp = temp.getNext();
            }
            temp.setNext(tail.getNext());
            tail = temp;
            size--;
            return val;
        }
    }

    public void rotate(){
        if(!isEmpty()){
            tail = tail.getNext();
        }
    }
    
    public void print() {
        CNode<E> curr = tail.getNext();
        for (int i = 0; i < size*2; i++) {
            System.out.print(curr.getElement() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    /*
     * NEW METHODS :-
     */

    public void deleteLargest(){
        if(isEmpty())
            return;
        
        CNode<E> curr = tail.getNext();
        CNode<E> maxNode = curr;
        
        int max = (int) curr.getElement();

        for(int i=0; i < size; i++ ){
            if((int) curr.getElement() > max){
                max = (int) curr.getElement();
                maxNode = curr;
            }
            curr = curr.getNext();
        }

        curr = tail.getNext();

        while(curr.getNext() != maxNode){
            curr = curr.getNext();
        }
        curr.setNext(maxNode.getNext());

        size--;

    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> c = new CircularlyLinkedList<>();

        c.addFirst(4);
        c.addFirst(3);
        c.addFirst(10);
        c.addFirst(2);
        c.addFirst(1);
        
        c.print();

        c.rotate();

        c.print();
    }
}
