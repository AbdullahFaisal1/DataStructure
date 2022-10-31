package BinarySearchTree;

public class BinarySearchTree < K extends Comparable<K>, E extends Comparable<E>> {
    private BSTNode<K,E> root;

    public BinarySearchTree(){
        root = null;
    }

    public BSTNode<K,E> getRoot(){
        return root;
    }

    public E search(K key){
        BSTNode<K,E> node = searchTree(root, key);
        if(node == null)
            return null;
        else
            return node.getData();   
    }
    private BSTNode<K,E> searchTree(BSTNode<K,E> node, K key){
        if(node == null)
            return null;
        else if(key.compareTo(node.getKey()) == 0)
            return node;
        else if(key.compareTo(node.getKey()) > 0)
            return searchTree(node.getRight(), key);
        else
            return searchTree(node.getLeft(), key);        
    }

    public void insert(K key, E data){
        BSTNode<K,E> parent = null;
        BSTNode<K,E> trav = root;
        while(trav != null){
            parent = trav;
            if(parent.getKey().compareTo(key) > 0){
                trav = trav.getLeft();
            }
            else if(parent.getKey().compareTo(key) < 0){
                trav = trav.getRight();
            }
        }
        BSTNode<K,E> newNode = new BSTNode<>(key, data);
        if(root == null)
            root = newNode;
        else if(parent.getKey().compareTo(key) > 0)
            parent.setLeft(newNode);
        else if(parent.getKey().compareTo(key) < 0){
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
            deleteNode(trav, parent);
            return removedData;
        }
    }

    public void deleteNode(BSTNode<K,E> toDelete, BSTNode<K,E> parent){
            if(toDelete.getLeft() != null && toDelete.getRight() != null){
                BSTNode<K,E> replaceParnet  = toDelete;
                BSTNode<K,E> replace = toDelete.getRight();

                toDelete.setKey(replace.getKey());
                toDelete.setData(replace.getData());

                deleteNode(replace, replaceParnet);
            }else{
                BSTNode<K,E> toDeleteChild;
                if(toDelete.getLeft() != null)
                    toDeleteChild = toDelete.getLeft();
                else
                    toDeleteChild = toDelete.getRight();

                if(toDelete == root)
                    root = toDeleteChild;
                else if(toDelete.getKey().compareTo(parent.getKey()) < 0)
                    parent.setLeft(toDeleteChild);
                else
                    parent.setRight(toDeleteChild);            
            }
    }

    public boolean contains(E data) {
		boolean val = contains(root, data);
		return val;
	}
	private boolean contains(BSTNode<K, E> node, E data) {
		if (node == null)
			return false;

		else if (data.compareTo(node.getData()) == 0)
			return true;

		return contains(node.getLeft(), data) || contains(node.getRight(), data);
	}

    public int numberOfLeaf(BSTNode<K,E> node){
        if(node == null)
            return 0;
        if(node.isLeaf())
            return 1;
        return numberOfLeaf(node.getLeft()) + numberOfLeaf(node.getRight());    
    }
    
}

