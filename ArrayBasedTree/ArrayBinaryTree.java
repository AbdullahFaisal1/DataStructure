package ArrayBasedTree;
// Array based tree 
// we use recursion

public class ArrayBinaryTree {
    ABTNode root;

    public void insert(ABTNode n, int parentK){
        if(root == null){
            ABTNode newNode = new ABTNode(n.data,0,null,null,null);
            root = newNode;
        }else{
            insert(n, parentK, root); // ما نجي داخل هذا الشرط الا ومتأكدين ان فيه روت
        }
    }
    public void insert(ABTNode n,int pKey, ABTNode parent){ //(D, 1, root)
        if(parent == null)return;

        if(parent.key == pKey){ // 0 != 1

            if(parent.left == null){
                ABTNode newNode = new ABTNode(n.data, 2*parent.key+1, parent, null,null);
                parent.left = newNode;
                return;
            }
            else if(parent.right == null){
                ABTNode newNode = new ABTNode(n.data, 2*parent.key+2, parent, null, null);
                parent.right = newNode;
                return;
            }
            else{
                System.out.println("Parent aredy has tow childs!");
                return;
            }

        }
        insert(n, pKey , parent.left);
        insert(n, pKey, parent.right);

    }

    public void delete(int key){
        if(root == null) return;
        else
            delete(key,root);
    }
    private void delete(int key, ABTNode parent){
        if(parent != null){

            if(parent.left != null && key == parent.left.key){
                parent.left = null;
                return;
            }
            else if(parent.right != null && key == parent.right.key){
                parent.right = null;
                return;
            }
            else{
                delete(key, parent.left);
                delete(key, parent.right);
            }

        }
    }

    public void printfromParent(ABTNode parent){
        if(parent == null) return;

        System.out.println(parent.data);
        printfromParent(parent.left);
        printfromParent(parent.right);
    }

    public void printTree(){
        printfromParent(root);
    } 
    public static void main(String[] args) {
        ABTNode a = new ABTNode('A', 0);
        ABTNode b = new ABTNode('B',0);
        ABTNode c = new ABTNode('C',2);
        ABTNode d = new ABTNode('D',3);
        ArrayBinaryTree t = new ArrayBinaryTree();

        t.insert(a, 0);
        t.insert(b, 0);
        t.insert(c, 1);
        t.insert(d, 2);

        

        
    }
}
