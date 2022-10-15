package LinkedBasedTree;

public class LBTNode <E> {
    private E item;
    private LBTNode<E> parent;
    private LBTNode<E> left;
    private LBTNode<E> right;
    private int x; // extra data
    private int y; // extra data

    public LBTNode(){
        parent = left = right = null;
        item = null;
        x = y = 0;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public LBTNode<E> getParent() {
        return parent;
    }

    public void setParent(LBTNode<E> parent) {
        this.parent = parent;
    }

    public LBTNode<E> getLeft() {
        return left;
    }

    public void setLeft(LBTNode<E> left) {
        this.left = left;
    }

    public LBTNode<E> getRight() {
        return right;
    }

    public void setRight(LBTNode<E> right) {
        this.right = right;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}


