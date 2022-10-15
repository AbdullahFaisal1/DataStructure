package LinkedBasedTree;

public class LinkedBinaryTree<E> {
    private LBTNode<E> root;
    private int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public boolean isRoot(LBTNode<E> node){
        if(node != null){
            if(node.getParent() == null){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean isEmpty(LBTNode<E> node){
        if(node == null){
            return true;
        }else{
            return false;
        }
    }

    public int size(LBTNode<E> node){
        if(node == null) return 0;
        else{
            return 1 + size(left(node)) + size(right(node));
        }
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
        }else
            return null;

    }

    public LBTNode<E> root(LBTNode<E> node){ // return root
        if(node != null){
            LBTNode<E> temp = node;
            while(temp.getParent() != null){
                temp = temp.getParent();
            }
            return temp;
        }else{
            return null;
        }
    }

    public E getElement(LBTNode<E> node){
        if(node != null){
            E e = node.getItem();
            return e;
        }else{
            return null;
        }
    }

    public E set(LBTNode<E> node, E e){
        if(node != null){
            E old = node.getItem();
            node.setItem(e);
            return old;
        }else{
            return null;
        }
    }

    public boolean isInternal(LBTNode<E> node){ // اذا لها أبناء
        if(node != null){
            if(node.getRight() != null || node.getLeft() != null){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean isExternal(LBTNode<E> node){ // isLeaf
        if(node != null){
            if(node.getLeft() == null && node.getRight() == null){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println("abdullah");

        LBTNode<Character> n1 = new LBTNode<>('A');
        LBTNode<Character> n2 = new LBTNode<>('B');
        LBTNode<Character> n3 = new LBTNode<>('C');
        LBTNode<Character> n4 = new LBTNode<>('D');
        LBTNode<Character> n5 = new LBTNode<>('E');

        LinkedBinaryTree<Character> linkedTree = new LinkedBinaryTree<>();
        linkedTree.addRoot(n1.getItem());

    }
}