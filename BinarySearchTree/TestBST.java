package BinarySearchTree;

public class TestBST {
    // traversals -----------------------------------------
    public static <K, E> void preOrder(BSTNode<K, E> p){
        if(p != null){
            System.out.print(p.getKey() + " ");
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }

    public static <K, E> void inOrder(BSTNode<K,E> p){
        if(p != null){
            inOrder(p.getLeft());
            System.out.print(p.getKey() + " ");
            inOrder(p.getRight());
        }
    }

    public static <K,E> void postOrder(BSTNode<K,E> p){
        if(p != null){
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.print(p.getKey() + " ");
        }
    }


    public static void main(String[] args) {
        BSTree<Integer, Character> bst = new BSTree<>();
        bst.insert(23, 'a');
        bst.insert(25, 'b');
        bst.insert(44, 'c');
        bst.insert(12, 'd');
        bst.insert(20, 'e');
        bst.insert(35, 'f');
        bst.insert(52, 'g');

        //inOrder(bst.getRoot());
    }
}
