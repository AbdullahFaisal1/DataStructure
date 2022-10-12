package CircularLinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class CNode<E> {

    private E element;
    private CNode<E> next;

    public CNode(E element, CNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(CNode<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public CNode<E> getNext() {
        return next;
    }
}
