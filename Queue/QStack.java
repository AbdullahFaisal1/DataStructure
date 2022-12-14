package Queue;
class Node<T>{
    public T element;
    public Node<T> next;
}

public class QStack<T>{
    public Node<T> top;
    public int size;

    public QStack(){
        size = 0;
        top = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T val){
        Node<T> temp = new Node<>();
        temp.element = val;
        if(isEmpty()){
            top = temp;
        }else{
            temp.next = top;
            top = temp;
        }
    }

    public T pop(){
        if(!isEmpty())
            return null;
        else{
            T value = (T) top.element;
            top = top.next;
            size--;
            return value;
        }   
    }

    public T top(){
        if(!isEmpty()){
            return top.element;
        }else{
            return null;
        }
    }

    public void printList(){
        Node<T> temp = top;
        while(temp != null){
            System.out.println(temp.element + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printList2(){
        QStack<T> temp = new QStack<>();

        while(!isEmpty()){
            System.out.println(top());
            temp.push(pop());
        }

        while(!temp.isEmpty()){
            push(temp.pop());
        }
    }

    public void printList3(){
        QStack<T> x = this;
        QStack<T> temp = new QStack<>();
        temp = x;

        while(!temp.isEmpty()){
            System.out.println(temp.pop());
        }
    }

}