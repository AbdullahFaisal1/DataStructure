package BinarySearchTree;

public class BSTNode<K, T> {
    private K key;
    private T data;
    private BSTNode<K,T> left;
    private BSTNode<K,T> right;

    public BSTNode(){
        left = right = null;
    }
    public BSTNode(K key, T data){
        this.key = key;
        this.data = data;
        left = right = null;
    }
    public BSTNode(K key, T data, BSTNode<K,T> left, BSTNode<K,T> right){
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

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<K, T> getLeft() {
        return left;
    }
    public void setLeft(BSTNode<K, T> left) {
        this.left = left;
    }

    public BSTNode<K, T> getRight() {
        return right;
    }
    public void setRight(BSTNode<K, T> right) {
        this.right = right;
    }

    public boolean isLeaf(){
        return (left == null) && (right == null);
    }

    

    
}
