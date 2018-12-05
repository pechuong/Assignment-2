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
	
	public void add(Object obj) throws Exception {
		Node newNode = new Node(obj);
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;	
		this.size++;
	}
	
	public void add(String key, Object value) {
		Node newNode = new Node(key, value);
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;	
		this.size++;
	}

	/*
	public void add(int pos, Object obj) throws Exception { 
		if (pos > this.size) {
			throw new Exception("pos: " + pos +" is greater than size");
		}
		if (pos == 0 || this.size == 0) {
			add(obj);	
			return;
		}
		int listPosition = 0;
		Node currNode = this.head;
		while (currNode.value != null && listPosition < pos) {
			currNode = currNode.next;
			listPosition++;
		}
		currNode.prev.next = new Node(obj);
		currNode.prev.next.prev = currNode.prev;
		currNode.prev.next.next = currNode;
		currNode.prev = currNode.prev.next;
		this.size++;
	}
	*/
	/*
	public Object get(int pos) throws Exception {
		if (pos < 0 || this.size == 0 || pos > this.size) {
			throw new Exception("Error getting pos: " + pos);
		}
		int listPosition = 0;
		Node currNode = this.head;
		while (currNode.value != null && listPosition < pos) {
			currNode = currNode.next;
			listPosition++;
		}
		return currNode.value;
	}
	*/
	
	public Object get(String key) throws Exception {
		if (this.size == 0) {
			throw new Exception("Nothing in linked list");
		}
		Node currNode = this.head;
		//System.out.println("Size of my linked list: " + this.size());
		//System.out.println("My key is: " + currNode.key);
		//System.out.println("The key I'm looking for is: " + key);
		//System.out.println("Next key: " + currNode.next.key);
		while (currNode.next.key != null) {
			//System.out.println("My key is: " + currNode.key);
			//System.out.println("The key I'm looking for is: " + key);
			if (currNode.key.equals(key)) {    
				break;
			}
			currNode = currNode.next;
		}
		return (currNode.key != null) ? (currNode.key.equals(key)) ? currNode.value : null : null;
	}
	
	public Object remove(int pos) throws Exception {
		if (pos < 0 || this.size == 0 || pos > this.size) {
			throw new Exception("Error removing with pos: " + pos);
		}
		Node currNode = this.head;
		if (this.size == 1 || pos == 0) {
			this.head = currNode.next;
			this.size--;
			return currNode.value;	
		}
		int listPosition = 0;
		while (listPosition < pos) {
			currNode = currNode.next;	
			listPosition++;
		}
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		this.size--;
		return currNode.value;
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
