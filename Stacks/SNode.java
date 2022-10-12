package Stacks;
public class SNode<E> {

    private E element;
    private SNode<E> next;

    public SNode(E element, SNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public SNode(E element){
        this(element, null);
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(SNode<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public SNode<E> getNext() {
        return next;
    }
}
