package HashTable.SeparateChaining;

// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
import java.util.ArrayList;
import java.util.Objects;

// A node of chains
class HashNode<V> {
	String key;
	V value;
	final int hashCode;

	// Reference to next node
	HashNode<V> next;

	// Constructor
	public HashNode(String key, V value, int hashCode)
	{
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}

    
}

// Class to represent entire hash table
public class SeparateChainMap<V> {
	// bucketArray is used to store array of chains
	private ArrayList<HashNode<V> > bucketArray;
	// Current capacity of array list
	private int numBuckets;
	// Current size of array list
	private int size;

	// Constructor (Initializes capacity, size and
	// empty chains.
	public SeparateChainMap()
	{
		bucketArray = new ArrayList<>();
		numBuckets = 26;
		size = 0;

		// Create empty chains
		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
	}

	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	
	private final int hashCode (String key) {
        char word = key.charAt(0);
		return Objects.hashCode(word) - 97;
	}

    // private final int hashCode(K key) {
		
	// 	return ((int)key)-97;
	// } 
    

	// This implements hash function to find index
	// for a key
	private int getBucketIndex(String key)
	{
		// int hashCode = hashCode(key);
		// int index = hashCode % numBuckets;
		// // key.hashCode() could be negative.
		// index = index < 0 ? index * -1 : index;
		// return index;
        return hashCode(key);
	}

	// Method to remove a given key
	public V remove(String key)
	{
		// Apply hash function to find index for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		// Get head of chain
		HashNode<V> head = bucketArray.get(bucketIndex);

		// Search for key in its chain
		HashNode<V> prev = null;
		while (head != null) {
			// If Key found
			if (head.key.equals(key) && hashCode == head.hashCode)
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		// If key was not there
		if (head == null)
			return null;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			bucketArray.set(bucketIndex, head.next);

		return head.value;
	}

	// Returns value for a key
	public V get(String key)
	{
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
	
		HashNode<V> head = bucketArray.get(bucketIndex);

		// Search key in chain
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode)
				return head.value;
			head = head.next;
		}

		// If key not found
		return null;
	}

	// Adds a key value pair to hash
	public void add(String key, V value)
	{
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		HashNode<V> head = bucketArray.get(bucketIndex);

		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Insert key in chain
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<V> newNode = new HashNode<V>(key, value, hashCode);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);

		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * size) / numBuckets >= 0.7) {
			ArrayList<HashNode<V> > temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for (int i = 0; i < numBuckets; i++)
				bucketArray.add(null);

			for (HashNode<V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	// Driver method to test Map class
	public static void main(String[] args)
	{
		SeparateChainMap<Integer> map = new SeparateChainMap<>();
		// map.add("this", 1);
		// map.add("coder", 2);
		// map.add("this", 4);
		// map.add("hi", 5);
		// System.out.println(map.size());
		// System.out.println(map.remove("this"));
		// System.out.println(map.remove("this"));
		// System.out.println(map.size());
		// System.out.println(map.isEmpty());

        map.add("abdullah",1);
        map.add("moner",2);
        map.add("ahmed",3);
        map.add("bader",4);
        map.add("mohamed",5);
        

	}
}

