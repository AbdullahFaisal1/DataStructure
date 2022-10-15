package LinkedBasedTree;

public class LinkedBinaryTree<E> {
    private LBTNode<E> root;
    private int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public boolean isRoot(LBTNode<E> node){
        return node == root;
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

    public LBTNode<E> parent(LBTNode<E> node){
        if(node != null){
            LBTNode<E> temp = node.getParent();
            return temp;
        }
        return null;
    }
    public LBTNode<E> left(LBTNode<E> node){
        if(node != null){
            LBTNode<E> temp = node.getLeft();
            return temp;
        }
        return null;
    }
    public LBTNode<E> right(LBTNode<E> node){
        if(node != null){
            LBTNode<E> temp = node.getRight();
            return temp;
        }
        return null;
    }

    public LBTNode<E> addLeft(LBTNode<E> parent, E element){
        LBTNode<E> newNode = new LBTNode<>();
        newNode.setItem(element);
        if(parent != null && parent.getLeft() == null){
            parent.setLeft(newNode);
            newNode.setParent(parent);
            size++;
            return newNode;
        }else{
            return null; 
        }
    }

    public LBTNode<E> addRight(LBTNode<E> parent, E element){
        LBTNode<E> newNode = new LBTNode<>();
        newNode.setItem(element);
        if(parent != null && parent.getRight() == null){
            parent.setRight(newNode);
            newNode.setParent(parent);
            size++;
            return newNode;
        }else{
            return null;
        }
    }

    public E remove(LBTNode<E> node){

        if(node != null){
            if(node.getLeft() != null && node.getRight() == null) {//ندخل اذا فيه يسار ومافيه يمبين
                if(!isRoot(node)){
                    LBTNode<E> parent = parent(node);
                    if(left(parent) == node)
                        parent.setLeft(node.getLeft());
                    if(right(parent) == node)
                        parent.setRight(node.getLeft());
                }else
                    root = node.getLeft();
                E e = node.getItem();
                return e;
            }

            if(node.getLeft() == null && node.getRight() != null){ //مافيه يسار وفيه يمين
                if(!isRoot(node)){
                    LBTNode<E> parent = parent(node);
                    if(left(parent) == node)
                        parent.setLeft(node.getRight());
                    if(right(parent) == node)
                        parent.setRight(node.getRight());
                }else
                    root = node.getRight();
                E e = node.getItem();
                return e;    
            }

            if(node.getLeft() != null & node.getRight() != null) //فيه يسار و يمين
                return null;
                
            if(node.getLeft() == null && node.getRight() == null){
                if(!isRoot(node)){
                    LBTNode<E> parent = parent(node);
                    if(left(parent) == node)
                        parent.setLeft(null);
                    if(right(parent) == node)
                        parent.setRight(null);
                }else
                    root = null;
                E e = node.getItem();
                return e;     
            }
            return null;   
        }else{
            return null;
        }
    }


    public static void main(String[] args) {
        System.out.println("abdullah");
    }
}