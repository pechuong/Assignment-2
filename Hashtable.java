import java.util.Arrays;

public class Hashtable<K, V> {

	public LinkedList[] arr;  /* Array of Linked list  	     */
	public int size;     	  /* size of the overall array       */

	/**
	 * Defaults the hashtable size to 2027
	 */
	public Hashtable() {
		this(2027);
	}

	/**
	 * Initializes the Hashtable with a given size
	 */
	public Hashtable(int size) {
		this.arr = new LinkedList[size];
		this.size = size;
	}

	/**
	 * Checks to see if the key exists in the hashMap
	 *
	 * @param key The key to search for
	 * @return true If the key exists, otherwise false
	 */
	public boolean containsKey(String key) {
		return (get(key) != null) ? true : false;	
	}

	/**
	 * Gets the value associated with the given key
	 * (First value at head of linkedlist)
	 *
	 * @param key The key to search for a value in
	 * @param String The value associated with the key or null if not found or DNE 
	 */
	public String get(String key) {
		int index = getIndex(key); 
		if (arr[index].size() > 0) {
			return arr[index].get(key) != null ? arr[index].get(key).toString() : null;
		} 
		return null;
	}

	/**
	 * Gets the Index in the array that the linked list for the key
	 * is stored in
	 *
	 * @param key The key to get the linked list / index of
	 * @return index of the linked list with the key
	 */
	public int getIndex(String key) {
		int hashCode = Math.abs(key.hashCode());
		return hashCode % size;
	}

	public void put(String key, String value) {
		int index = getIndex(key);
		try {
			if (arr[index] == null) {
				LinkedList temp = new LinkedList();
				temp.add(key, value);
				arr[index] = temp;
			} else {
				arr[index].add(key, value);
			}
		} catch (Exception e) {
			System.out.println(e + " Error caught in put method");
		}
	}

	public String remove(String key) throws Exception {
		// If I don't get a value from get or if the key doesn't exist
		// I want to throw an exception
		if (!containsKey(key)) {
			throw new Exception("No key/value pair found for the key: " + key);
		}
		int index = getIndex(key); 
		Object temp = arr[index].remove(key);
		return temp.toString();
	}

	@Override
	public String toString() {
		return this.toString();
	}
}
