package BinarySearchTree;

public class BSTree <K extends Comparable<K>, E> {
    private BSTNode<K,E> root;
    public BSTree(){
        root = null;
    }

    public E search(K key){
        BSTNode<K,E> n = searchTree(root, key);
        if(n == null){
            return null;
        }else{
            return n.getData();
        }
    }
    private BSTNode<K,E> searchTree(BSTNode<K,E> n, K key){
        if(n == null)
            return null;
        else if(key.compareTo(n.getKey()) == 0)
            return n;
        else if(key.compareTo(n.getKey()) > 0)
            return searchTree(n.getRight(), key);
        else
            return searchTree(n.getLeft(), key);        
    }

    public void insert(K key, E data){
        BSTNode<K,E> parent = null;
        BSTNode<K,E> trav = null;
        while(trav != null){
            parent = trav;
            if(parent.getKey().compareTo(key) > 0){
                trav = trav.getLeft();
            }
            else if(parent.getKey().compareTo(key) <= 0){
                trav = trav.getRight();
            }
        }
        BSTNode<K,E> newNode = new BSTNode<>(key, data);
        if(root == null){
            root = newNode;
        }
        else if(parent.getKey().compareTo(key) > 0)
            parent.setLeft(newNode);
        else if(parent.getKey().compareTo(key) <= 0){
            parent.setRight(newNode);
        }    
    }


    public E delete (K key){
        BSTNode<K, E> parent = null;
        BSTNode<K, E> trav = root;

        while(trav != null && trav.getKey() != key){
            parent = trav;
            if(key.compareTo(parent.getKey()) < 0){
                trav = trav.getLeft();
            }else
                trav = trav.getRight();
        }
        if(trav == null) // no such key{}
            return null;
        else{
            E removedData = trav.getData();
            //deleteNode(trav, parent);
            return removedData;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
    
}

