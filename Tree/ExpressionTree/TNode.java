/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExpressionTree;

public class TNode<E> {
private E item;
private TNode<E> parent;
private TNode<E> left;
private TNode<E> right;
public TNode() {
item = null;
parent = null;
left = null;
right = null;
}
public void setItem(E e) {item = e; }

public void setParent(TNode<E> n) { parent = n; }

public void setLeft(TNode<E> n) { left = n; }

public void setRight(TNode<E> n) { right = n;}

public E getItem() { return item; }

public TNode<E> getParent() { return parent; }
public TNode<E> getLeft() { return left; }
public TNode<E> getRight() { return right; }
}

