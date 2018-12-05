import java.util.Arrays;

public class Hashtable<K, V> {

	public LinkedList[] arr;  /* Array of Linked list  	   */
	public int size;     		/* size of the overall array       */
	public int numItems; 		/* num of Linked List in the array */

	/**
	 * Initializes the Hashtable with:
	 * - default size of 10 as the array
	 * - zero items
	 */
	public Hashtable() {
		this.arr = null;
		createArray();
		/*
		for (int i = 0; i < arr.length; i++) {
			System.out.println("position " + i + " contains " + this.arr[i]);
		} */
		this.size = 10;
		this.numItems = 0;
		//System.out.println("Array: " + Arrays.toString(arr));
	}
	
	public void createArray() {
		LinkedList[] temp = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			temp[i] = new LinkedList(); 
		}
		arr = temp;
	}

	/**
	 * Checks to see if the key exists in the hashMap
	 *
	 * @param key The key to search for
	 * @return true If the key exists, otherwise false
	 */
	public boolean containsKey(String key) {
		//System.out.println("get(key): " + get(key));
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
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % size;
		//System.out.println("HashCode: " + hashCode);
		//System.out.println("Size: " + size);
		//System.out.println("Hash % size: " + (hashCode % size));
		try {
			if (arr[index].size() > 0) {
				//System.out.println("Index: " + index);
				//System.out.println("arr[index]: " + arr[index]);
				//System.out.println("arr[index].get(key): " + arr[index].get(key));
				return arr[index].get(key) != null ? arr[index].get(key).toString() : null;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return null;
	}

	public void put(String key, String value) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % size;
		try {
			//System.out.println(arr[hashCode % size]);
			//System.out.println(!containsKey(key));
			if (arr[index] == null) {
				//System.out.println("Creating new linkedlist");
				LinkedList temp = new LinkedList();
				temp.add(key, value);
				arr[index] = temp;
				numItems++;
			} else {
				//System.out.println("Starting to add to list");
				arr[index].add(key, value);
				//System.out.println("Added to LinkedList");
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
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % size;
		Object temp = arr[index].remove(0);
		return temp.toString();
	}

	@Override
	public String toString() {
		return this.toString();
	}
}
