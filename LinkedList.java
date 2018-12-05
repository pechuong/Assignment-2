public class LinkedList /*implements List*/ {
	
	public class Node {
		public String key;
		public Object value;
		public Node next;
		public Node prev;
		
		public Node(Object value) {
			this(null, value);
		}

		public Node(String key, Object value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	public Node head;
	public int size;

	public LinkedList() {
		this.head = new Node(null, null);
		this.size = 0;
	}
	
	public void add(String key, Object value) {
		Node newNode = new Node(key, value);
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;	
		this.size++;
	}
	
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

	public int size() {
		return this.size;
	}

}
