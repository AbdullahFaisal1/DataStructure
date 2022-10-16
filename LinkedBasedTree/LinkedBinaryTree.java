package LinkedBasedTree;

import Queue.Queue;
import Stacks.Stack;

public class LinkedBinaryTree<E> {
    private LBTNode<E> root;
    private int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public void setRoot(LBTNode<E> root){
        this.root = root;
    }

    public LBTNode<E> getRoot(){
        return root;
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

    //new Methods

    public void preOrder(LBTNode<E> node){
        if(node != null){
            System.out.print(node + " ");
            preOrder(left(node));
            preOrder(right(node));
        }
    }

    public void inOrder(LBTNode<E> node){
        if(node != null){
            inOrder(node.getLeft());
            System.out.println(node + " ");
            inOrder(node.getRight());
        }
    }

    public void postOrder(LBTNode<E> node){
        if(node != null){
            postOrder(node);
            postOrder(node);
            System.out.println(node + " ");
        }
    }

    public void breadthFrist(LBTNode<E> node){ //level counting
        if(node != null){
            Queue<LBTNode<E>> tg = new Queue<LBTNode<E>>();
            tg.enqueue(node);
            while(!tg.empty()){
                LBTNode<E> temp = tg.serve();
                if(temp != null){
                    System.out.println(temp.getItem());

                    if(temp.getLeft() != null){
                        tg.enqueue(temp.getLeft());
                    }
                    if(temp.getRight() != null){
                        tg.enqueue(temp.getRight());
                    }
                }
            }
        }
    }

    public String printExpression(LBTNode<Character> node){ //inOrder
        String s = "";
        LBTNode<Character> n = node;
        if(node != null){

            if(node.getLeft() != null){
                s += "(";
                s += printExpression(node.getLeft());
            }

            s += node.getItem();

            if(node.getRight() != null){
                s += printExpression(node.getRight());
                s += ")";
            }
            
        }
        return s;
    }

    public int evalExpression(LBTNode<Character> node){ //inOrder
        LBTNode<Character> n = node;
        if(node != null){
            if(node.getLeft() != null && node.getRight() != null){
                return Character.getNumericValue(node.getItem());
            }else{
                int x = evalExpression(node.getLeft());
                int y = evalExpression(node.getRight());
                switch(node.getItem()){
                    case '+':
                        return x+y;
                    case '-':
                        return x-y;
                    case '*':
                        return x*y;
                    case '/':
                        return x/y;
                    case '%':
                        return x%y;
                    default:
                        return 0;
                }
            }
        }else{
            return 0;
        }
    }

    public int depth(LBTNode<E> node){
        if(node != null){
            LBTNode<E> temp = node.getParent();
            int d = 0;
            while(temp != null){
                d++;
                temp = temp.getParent();
            }
            return d;
        }else{
            return -1;
        }
    }

    public int inOrderRank(LBTNode<E> node, int x){
        if(node != null){
            if(left(node) != null)
                x = inOrderRank(left(node), x);
            x++;
            if(right(node) != null)
                x = inOrderRank(right(node), x);
            return x;        
        }else{
            return x;
        }
    }

    public LinkedBinaryTree<Character> postFixToExpTree(String s){
        Stack<LBTNode<Character>> tstack = new Stack<>();
        LinkedBinaryTree<Character> btc = new LinkedBinaryTree<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            switch(curr){
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    LBTNode<Character> op = new LBTNode<>();
                    op.setItem(curr);
                    op.setRight(tstack.pop());
                    op.setLeft(tstack.pop());
                    tstack.push(op);
                    break;
                default:
                    LBTNode<Character> tn = new LBTNode<>();
                    tn.setItem(curr);
                    tstack.push(tn);    
            }
        }
        btc.setRoot(tstack.pop());
        return btc;
    }

    // public boolean attach(LBTNode<E> node, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2){
    //     if(node.getLeft() == null && node.getRight() == null){
    //         node.setLeft();
    //     }else{
    //         return false;
    //     }
    // }



    public static void main(String[] args) {
        System.out.println("abdullah");

        LBTNode<Character> n1 = new LBTNode<>('A');
        LBTNode<Character> n2 = new LBTNode<>('B');
        LBTNode<Character> n3 = new LBTNode<>('C');
        LBTNode<Character> n4 = new LBTNode<>('D');
        LBTNode<Character> n5 = new LBTNode<>('E');

        
        LinkedBinaryTree<Character> linkedTree = new LinkedBinaryTree<>();

        linkedTree.addRoot(n1.getItem());

        linkedTree.addLeft(n1, n2.getItem());
        linkedTree.addRight(n1, n3.getItem());

        linkedTree.addLeft(n2, n4.getItem());


    }
}