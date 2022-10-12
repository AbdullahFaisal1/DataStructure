package DoubleLinkedList;
public class DNode<E> {
    private E element; // reference to the element stored at this node
    private DNode<E> prev; // reference to the previous node in the list
    private DNode<E> next; // reference to the subsequent node in the list

    public DNode(E e, DNode<E> p, DNode<E> n) {
        element = e;
        prev = p;
        next = n;
    }

    public E getElement() {
        return element;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setPrev(DNode<E> p) {
        prev = p;
    }

    public void setNext(DNode<E> n) {
        next = n;
    }
}
