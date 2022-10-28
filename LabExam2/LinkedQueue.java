

public class LinkedQueue<E> {

    private SQNode<E> front; // Reference to front queue node
    private SQNode<E> last; // Reference to last queue node
    private int size; // Number of elements in queue

    /**
     * Constructors
     */
    public LinkedQueue() {
        front = last = null;
        size = 0;
    }

    /**
     * @return Queue size
     */
    public int length() {
        return size;
    }

    /**
     * Clear
     */
    public void clear() {
        front = last = null;
        size = 0;
    }

    /**
     * Put element on last
     */
    public void enqueue(E data) {
        SQNode<E> temp = new SQNode<E>(data, null);
        if (size == 0) {
            front = last = temp;
        } else {
            last = last.next = temp;
        }
        size++;
    }

    /**
     * Remove and return element from front
     */
    public E dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        E data = front.data; // Store dequeued value
        front = front.next; // Advance front
        if (front == null) {
            last = front; // Last Object
        }
        size--;
        return data; // Return Object
    }

    /**
     * @return Front data
     */
    public E frontValue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Queue is empty");

        }
        for (int i = 0; i < size; i++) {
            System.out.print(front.data);
            System.out.print(" ");
            enqueue(dequeue());
        }
        System.out.println("");

    }

}
