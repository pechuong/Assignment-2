/**
 * A linked list specifically for the hashtable class
 * (Modified from practice assignment)
 *
 * @author Peter Chuong
 * @version 1.0.0
 */
public class LinkedList {
	
	/**
	 * Nodes for the linked list
	 * - each have a key and value
	 * - points to next and prev nodes
	 */
	public class Node {
		public String key;
		public Object value;
		public Node next;
		public Node prev;
		
		/**
		 * Initializes Node
		 *
		 */
		public Node(String key, Object value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	/* Linked List Instance Members */
	public Node head;  /* head of the linked list */
	public int size;   /* size of linked list */ /* doesn't include the dummy head */

	/**
	 * Initializes the Linked List with a dummy head 
	 */
	public LinkedList() {
		this.head = new Node(null, null);
		this.size = 0;
	}
	
	/**
	 * Adds a key/value pair to the linked list
	 *
	 * @param key The key where to store the value under
	 * @param value The value to associate with the key
	 */
	public void add(String key, Object value) {
		Node newNode = new Node(key, value);
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;	
		this.size++;
	}

	/**
	 * Gets the value associated with the key
	 *
	 * @param key The key to find a value for
	 * @return value associated with key or null if there is none
	 */
	public Object get(String key) {
		if (this.size == 0) {
			return null;
		}
		Node currNode = this.head;
		while (currNode.next.key != null && !currNode.key.equals(key)) {
			currNode = currNode.next;
		}
		return (currNode.key.equals(key)) ? currNode.value : null;
	}
	
	/**
	 * Removes the key/value pair given a key
	 *
	 * @param key The key pair to remove
	 * @return Object The value removed
	 * @throws Exception 
	 */
	public Object remove(String key) throws Exception {
		if (this.size == 0) {
			throw new Exception("Error removing from an empty linked list");
		}
		Node currNode = this.head;
		if (this.size == 1 && currNode.key.equals(key)) {
			this.head = currNode.next;
			this.size--;
			return currNode.value;	
		}
		while (currNode.next.key != null && !currNode.key.equals(key)) {
			currNode = currNode.next;	
		}
		if (currNode.key.equals(key)) {
			currNode.prev.next = currNode.next;
			currNode.next.prev = currNode.prev;
			this.size--;
			return currNode.value;
		}
		return null;
	}

	/**
	 * Gets the size of the linked list
	 * (excluding dummy head)
	 *
	 * @return int The size of the linked list
	 */
	public int size() {
		return this.size;
	}

}
