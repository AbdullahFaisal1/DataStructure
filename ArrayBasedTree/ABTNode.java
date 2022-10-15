package ArrayBasedTree;
public class ABTNode{
    public int key;
    public char data;
    public ABTNode left;
    public ABTNode right;
    public ABTNode parent;

    public ABTNode(){
        left = right = null;
    }

    public ABTNode(char data, int key){
        this.key = key;
        this.data = data;
        left = right = null;
    }

    public ABTNode(int key, char data, ABTNode left, ABTNode right, ABTNode parent) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public ABTNode(char data,int key , ABTNode left, ABTNode right, ABTNode parent) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    
}