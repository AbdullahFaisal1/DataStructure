package Stacks;
public class Stack<E> {
    private SNode<E> top;
    private int size;

    public Stack(){
        top = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E e) {
        SNode<E> tmp = new SNode<E>(e);
        tmp.setNext(top);
        top = tmp;
        size++;
    }

    public E pop() {
        E val = top.getElement();
        top = top.getNext();
        size--;
        return val;
    }

    public E peak() {
        return top.getElement();
    }



    


}
