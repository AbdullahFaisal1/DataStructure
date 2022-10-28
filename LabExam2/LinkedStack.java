

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class LinkedStack<E> {

    private SQNode<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E data) {
        // Make a new node whose next reference is the existing list
        SQNode<E> newNode = new SQNode<>(data, top);
        top = newNode; // top points to new node
        size++;
    }

    public E pop() {
        if (top == null)
            return null;

        E t = top.data; // Save the value at the top of the stack
        top = top.next; // Make top reference points to the next node in the stack
        size--;

        return t; // return the removed value
    }

    public E top() {
        if (top == null)
            return null;

        return top.data;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Queue is empty");

        }
        for (int i = 0; i < size; i++) {
            System.out.print(top.data);
            System.out.print(" ");
            push(pop());
        }
        System.out.println("");

    }

}
