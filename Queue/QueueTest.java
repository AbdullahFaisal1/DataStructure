package Queue;

import java.util.Stack;

public class QueueTest {
    public static void main(String[] args) {
        // LinkedQueue<Integer> qu = new LinkedQueue<>();
        // LinkedQueue<Integer> qu2 = new LinkedQueue<>();
        

        // qu.enqueue(1);
        // qu.enqueue(2);
        // qu.enqueue(3);
        // qu2.enqueue(4);
        // qu2.enqueue(5);
        // qu2.enqueue(6);



        // qu.printList();
        // qu2.printList();

        // exchange(qu, qu2);
        // System.out.println();

        // qu.printList();
        // qu2.printList();


        // LinkedQueue<Character> q = new LinkedQueue<>();
        // q.enqueue('A');
        // q.enqueue('B');
        // q.enqueue('C');
        // q.enqueue('D');

        // printQ(q);

        Queue<Integer> q = new Queue<>();
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);

        printQ(q);

        printQ(q);

    }

    public static <T> void printQ(Queue<T> qu){
        for(int i=0; i<qu.length(); i++){
            T val = qu.serve();
            System.out.print(val + " --> ");
            qu.enqueue(val);
        }
        System.out.println();
    }

    public static <T> void split(Queue<T> origanalQ, Queue<T> oddQ, Queue<T> evenQ){
        for(int i=0; i<origanalQ.length(); i++){ // or int i=1; i<=origanalQ.length(); i++
            T val = origanalQ.serve();
            origanalQ.enqueue(val);

            if(i % 2 == 0){
                evenQ.enqueue(val);
            }else{
                oddQ.enqueue(val);
            }
        }
    }

    public static <T> void exchange(Queue<T> q1, Queue<T> q2){
        int q1Lingth = q1.length();
        int q2Lingth = q2.length();

        for(int i=0; i<q2Lingth; i++){
            q1.enqueue(q2.serve());
        }

        for(int i=0; i<q1Lingth; i++){
            q2.enqueue(q1.serve());
        }
    }

    public static <T> T enquiry(Queue<T> q){
        T data = q.serve();
        q.enqueue(data);

        for(int i=0; i<q.length()-1; i++){
            q.enqueue(q.serve());
        }
        return data;
    }
    public static <T> T frist(Queue q){
        T data = (T) q.peak();
        return data;
    }

    public static<T> Queue<T> warpQueue(Queue<T> q1, int x){
        for(int i=0; i<x; i++){
            q1.enqueue(q1.serve());
        }
        return q1;
    }

    public static<T> Queue<T> revQue(Queue<T> q1, int x){
        Stack<T> s = new Stack<>();

        for(int i=0; i<x; i++){
            s.push(q1.serve());
        }

        for(int i=0; i<x; i++){
            q1.enqueue(s.pop());
        }

        for(int i=0; i<q1.length() - x; i++){
            q1.enqueue(q1.serve());
        }
        return q1;
    }

}
