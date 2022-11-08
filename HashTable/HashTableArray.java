package HashTable;

public class HashTableArray<T> {
    HNode<T>[] hashArray;
    int size;

    public HashTableArray(int size){
        this.size = size;
        hashArray = new HNode[this.size];
        for(int i=0; i<hashArray.length; i++){
            hashArray[i] = new HNode<T>();
        }
    }

    int getHash(int key){
        return key % size;
    }

    // public void put(int key, T value){
    //     int index = getHash(key);
    //     HNode<T> head = hashArray[index];
    //     HNode<T> newNode = new HNode<>(key, value);
    //     // newNode.setNext(head.getNext()); // add at front
    //     // head.setNext(newNode);
    //     newNode.next = head.next;
    //     head.next = newNode;
    // }

    public void put(int key, T value){
        int index = getHash(key);
        HNode<T> head = hashArray[index];
        HNode<T> newNode = new HNode<>(key, value);
        // newNode.setNext(head.getNext()); // add at front
        // head.setNext(newNode);
        newNode.next = head.next;
        head.next = newNode;
    }

    public T get(int key){
        T value = null;
        int index = getHash(key);
        HNode<T> temp = hashArray[index];
        while(temp.next != null){
            if(temp.getKey() == key){
                value = temp.getValue();
                break;
            }
            temp = temp.next;
        }
        return value;
    }
    
    public static void main(String[] args) {
        HashTableArray<String> hash = new HashTableArray<>(10);
        hash.put(8, "Abdullah");


        System.out.println(hash.get(10));
    }
}
