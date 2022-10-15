package LinkedBasedTree;

public class LinkedBinaryTree<E> {
    private LBTNode<E> root;
    private int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public LBTNode<E> addRoot(E e){
        LBTNode<E> newNode = new LBTNode<>();
        newNode.setItem(e);
        if(root == null){
            root = newNode;
            size++;
            return newNode;
        }
        else return null;
    }

    public static void main(String[] args) {
        System.out.println("abdullah");
    }
}