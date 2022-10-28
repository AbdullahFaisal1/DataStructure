/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class SQNode<E> {

    public E data;
    public SQNode<E> next;

    public SQNode(E data, SQNode<E> next) {
        this.data = data;
        this.next = next;
    }

}