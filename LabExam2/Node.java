/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Node<E> {

    public E data;
    public Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}