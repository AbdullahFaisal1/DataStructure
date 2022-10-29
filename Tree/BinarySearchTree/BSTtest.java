package BinarySearchTree;

public class BSTtest {
    public static void main(String[] args) {
        
        BSTree<Integer,Character> bst = new BSTree<>();
        bst.insert(23, 'A');
        bst.insert(18, 'B');
        bst.insert(44, 'C');
        bst.insert(12, 'D');
        bst.insert(20, 'E');
        bst.insert(35, 'F');
        bst.insert(52, 'G');

        preOrder(bst.getRoot());
        System.out.println();
        inOrder(bst.getRoot());
        System.out.println();
        postOrder(bst.getRoot());
        


    }

    //traversal -------------------------------------------------------------------------
    public static <K, E> void preOrder(BSTNode<K,E> p){
        if(p != null){
            System.out.print(p.getKey() + " ");
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }

    public static <K,E> void inOrder(BSTNode<K,E> p){
        if(p != null){
            inOrder(p.getLeft());
            System.out.print(p.getKey() + " ");
            inOrder(p.getRight());
        }
    }

    public static <k,E> void postOrder(BSTNode<k,E> p){
        if(p != null){
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.print(p.getKey() + " ");
        }
    }


}
