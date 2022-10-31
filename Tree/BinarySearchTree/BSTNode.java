package BinarySearchTree;

public class BSTNode<K, E> {
    private K key;
    private E data;
    private BSTNode<K,E> left;
    private BSTNode<K,E> right;

    public BSTNode(){
        left = right = null;
    }
    public BSTNode(K key, E data){
        this.key = key;
        this.data = data;
        left = right = null;
    }
    public BSTNode(K key, E data, BSTNode<K,E> left, BSTNode<K,E> right){
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public K getKey(){
        return key;
    }
    public void setKey(K key){
        this.key = key;
    }

    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }

    public BSTNode<K, E> getLeft() {
        return left;
    }
    public void setLeft(BSTNode<K, E> left) {
        this.left = left;
    }

    public BSTNode<K, E> getRight() {
        return right;
    }
    public void setRight(BSTNode<K, E> right) {
        this.right = right;
    }

    public boolean isLeaf(){
        return (left == null && right == null);
    }

    

    
}
