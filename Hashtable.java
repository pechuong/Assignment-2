import java.util.Arrays;

public class Hashtable<K, V> {

	public final LinkedList[] arr;  /* Array of Linked list  	   */
	public int size;     		/* size of the overall array       */
	public int numItems; 		/* num of Linked List in the array */

	/**
	 * Initializes the Hashtable with:
	 * - default size of 10 as the array
	 * - zero items
	 */
	public Hashtable() {
		this.arr = new LinkedList[10];
		this.size = 10;
		this.numItems = 0;
		//System.out.println("Array: " + Arrays.toString(arr));
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
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % size;
		//System.out.println("HashCode: " + hashCode);
		//System.out.println("Size: " + size);
		//System.out.println("Hash % size: " + (hashCode % size));
		if (index >= size) {
			return null;
		}
		try {
			if (arr[hashCode % size] != null) {
				return arr[hashCode % size].get(0).toString();
			}
		} catch (Exception e) {
			System.out.println(e + " when in get(key) method");
		}
		return null;
		//return (arr[hashCode % size] != null) ? arr[hashCode % size].get(0).toString() : null;
	}

	public void put(String key, String value) {
		if (size + 1 >= arr.length) {
			growArray();
		}
		int hashCode = key.hashCode();
		try {
			//System.out.println(arr[hashCode % size]);
			if (arr[hashCode % size] == null) {
				LinkedList temp = new LinkedList();
				temp.add(value);
				arr[hashCode % size] = temp;
				numItems++;
			} else {
				arr[hashCode % size].add(value);
			}
		} catch (Exception e) {
			//System.out.println(e + " Error caught in put method");
		}
	}

	public String remove(String key) throws Exception {
		// If I don't get a value from get or if the key doesn't exist
		// I want to throw an exception
		if (get(key) == null || !containsKey(key)) {
			throw new Exception("No key/value pair found for the key: " + key);
		}
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % size;
		return arr[index].remove(0).toString();
	}

	public void growArray() {
		
	}

	@Override
	public String toString() {
		return this.toString();
	}
}
