package DoubleLinkedList;
/** A basic doubly linked list implementation. */
public class DoublyLinkedList<E> {
   // instance variables of the DoublyLinkedList
   private DNode<E> header; // header sentinel
   private DNode<E> trailer; // trailer sentinel
   private int size = 0; // number of elements in the list

   /** Constructs a new empty list. */
   public DoublyLinkedList() {
      header = new DNode<>(null, null, null); // create header
      trailer = new DNode<>(null, header, null); // trailer is preceded by header
      header.setNext(trailer); // header is followed by trailer
   }

   /** Returns the number of elements in the linked list. */
   public int size() {
      return size;
   }

   /** Tests whether the linked list is empty. */
   public boolean isEmpty() {
      return size == 0;
   }

   /** Returns (but does not remove) the first element of the list. */
   public E first() {
      if (isEmpty())
         return null;
      return header.getNext().getElement(); // first element is beyond header
   }

   /** Returns (but does not remove) the last element of the list. */
   public E last() {
      if (isEmpty())
         return null;
      return trailer.getPrev().getElement(); // last element is before trailer
   }

   // public update methods
   /** Adds element e to the front of the list. */
   public void addFirst(E e) {
      addBetween(e, header, header.getNext()); // place just after the header
   }

   /** Adds element e to the end of the list. */
   public void addLast(E e) {
      addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
   }

   /** Removes and returns the first element of the list. */
   public E removeFirst() {
      if (isEmpty())
         return null; // nothing to remove
      return remove(header.getNext()); // first element is beyond header
   }

   /** Removes and returns the last element of the list. */
   public E removeLast() {
      if (isEmpty())
         return null; // nothing to remove
      return remove(trailer.getPrev()); // last element is before trailer
   }

   // private update methods
   /** Adds element e to the linked list in between the given nodes. */
   private void addBetween(E e, DNode<E> predecessor, DNode<E> successor) {
      // create and link a new node
      DNode<E> newest = new DNode<>(e, predecessor, successor);
      predecessor.setNext(newest);
      successor.setPrev(newest);
      size++;
   }

   /** Removes the given node from the list and returns its element. */
   private E remove(DNode<E> node) {
      DNode<E> predecessor = node.getPrev();
      DNode<E> successor = node.getNext();
      predecessor.setNext(successor);
      successor.setPrev(predecessor);
      size--;
      return node.getElement();
   }

   public void print() {
      if (isEmpty())
         return;
      DNode<E> curr = header.getNext();
      while (curr != trailer) {
         System.out.print(curr.getElement() + " --> ");
         curr = curr.getNext();
      }
      System.out.println();
   }

   // Members Methods :-

   public void deleteLargest(){
      if(isEmpty()){
         return;
      }

      DNode<E> curr = header.getNext();
      DNode<E> maxNode = header.getNext();

      int max = (int)curr.getElement();

      while(curr != trailer){
         if((int) curr.getElement() > max){
            max = (int) curr.getElement();
            maxNode = curr;
         }
         curr = curr.getNext();
      }

      maxNode.getPrev().setNext(maxNode.getNext());
   }

   public void removeOdd(){
      if(isEmpty())
         return;
      
      DNode<E> curr = header.getNext();
      DNode<E> prev = header.getNext();

      while(curr != trailer){
         curr = curr.getNext();
         if((int)curr.getElement() % 2 != 0){
            prev.setNext(curr.getNext());
            size--;
         }else{
            prev.setNext(curr);
         }
      }

      curr = header.getNext();

      if((int)curr.getElement() % 2 != 0){
         header.setNext(curr.getNext());
         size--;
      }
   }

   public static void main(String[] args) {
      DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
      d.addFirst(6);
      d.addFirst(2);
      d.addFirst(3);
      d.addFirst(8);

      d.print();

      d.deleteLargest();

      d.print();

      System.out.println("-------------------------");


      DoublyLinkedList<Request> list = new DoublyLinkedList<>();

      list.addLast(new Request(101, 5));
      list.addLast(new Request(102, 10));
      list.addLast(new Request(103, 15));
      list.addLast(new Request(104, 20));

      list.print();

      int size = list.size();

      for(int i=0; i < size; i++){
         Request r = list.removeFirst();
         if(r.getId() == 103){
            r.setId(133);
         }
         list.addLast(r);
      }

      System.out.println();
      list.print();


      
   }

} // ----------- end of DoublyLinkedList class -----------
