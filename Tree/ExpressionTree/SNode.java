package ExpressionTree;

public class SNode <E>{
    
    public E data;
    public SNode<E> next;


    public SNode(E data, SNode<E> next) {
        this.data = data;
        this.next = next;
    }

   
}