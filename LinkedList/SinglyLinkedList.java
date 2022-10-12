package LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }
    // Remove all elements

    public void clear() {
        head = tail = null;
        size = 0;
    }
    // access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // special case: previously empty list
        } else {
            tail.setNext(newest); // new node after existing tail
        }
        tail = newest; // new node becomes the tail
        size++;
    }

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) // add at front
        {
            // newest.setNext(head);
            // head = newest;
            // if (tail == null) {
            //     tail = head;
            // }
            addLast(element);
        } else // add the middle
        {
            Node<E> curr = head;
            for (int i = 0; i < index - 1; i++) { // current is the indext before the index we want to put the new node if the index is 1 the current will be in 0 becose of(i<index-1)
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) // remove from front
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Node<E> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element = (E) curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }
        size--;
        return element;
    }

    public void print() {
        if (isEmpty()) {
            System.out.print("List is empty");
            return;
        }
        Node<E> curr = head;
        while (curr != null) {
            System.out.print(curr.getElement() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    // Members Methods :-

    public void swap(){
        Node<E> temp = head;
        while( temp != null && temp.getNext() != null){

            E val = (E) temp.getElement(); // val of head
            temp.setElement(temp.getNext().getElement()); //set for head
            temp.getNext().setElement(val); // set for next the head

            temp = temp.getNext().getNext();
        }
    }

    public void removeDuplicates(){
        Node<E> value = head;
        Node<E> curr = null;

        while(value != null && value.getNext() != null){

            curr = value;
            
            while(curr.getNext() != null){
                if(value.getElement() == curr.getNext().getElement()){
                    curr.setNext(curr.getNext().getNext());
                }else{
                    curr = curr.getNext();
                }
            }

            value = value.getNext();
        }
    }

    public void removeOdd(){
        
        if(head == null)
            return;
        
        Node<E> curr = head;
        Node<E> pre = curr;

        while(curr.getNext() != null){
            curr = curr.getNext();
            if( (Integer) curr.getElement() % 2 != 0){ // if odd
                pre.setNext(curr.getNext()); //skip
                size--;
            }else{
                pre = pre.getNext();
            }
        }

        if( (Integer) head.getElement() % 2 != 0){
            head = head.getNext();
        }
    }


    // public void deleteLargest(){
    //     Node<E> curr = head;
    //     int max = (int) curr.getElement();

    //     while(curr.getNext() != null){
    //         if(max >  (Integer)curr.getNext().getElement()){
    //             max = (Integer)curr.getNext().getElement();
    //         }
    //         curr = curr.getNext();
    //     }

    //     while(size == curr.getElement())
    // }

    public void deleteLargest(){
        if(isEmpty())
            return;
        
        Node<E> curr = head;
        Node<E> maxNode = head;
        
        int max  = (int) head.getElement();

        while(curr != null){
            if((int)curr.getElement() > max){
                max = (Integer)curr.getElement();
                maxNode = curr;
            }
            curr = curr.getNext();
        }

        curr = head;

        if(curr == maxNode){
            head = head.getNext();
            return;
        }

        while(curr.getNext() != maxNode){
            curr = curr.getNext();
        }
        curr.setNext(maxNode.getNext());
    }
        
    

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.print();

        list.swap();

        list.print();
    }

}