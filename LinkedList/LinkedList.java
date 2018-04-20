public class Node {
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedList {
	
	Node head;
	
	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void prepend(int data) {
		
		Node newHead = new Node(data);
		newHead.next = this.head;
		this.head = newHead;
	}
	
	public void deleteWithValue(int data) {
		if (head == null) return;
		if (data == head.data) {
			head = head.next;
		}
		
		Node current = this.head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public void deleteAllWithValue(int data) {
		if (head == null) return;

		Node current = this.head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
			}
			current = current.next;
		}
		
		if (data == head.data) {
			head = head.next;
		}
	}
	
}