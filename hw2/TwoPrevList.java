/**
 * A double linked list implementation
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * @author Zoe Millard
 * @since 10-6-15
 */
import java.util.*;
public class TwoPrevList{
	/**
	 * Node class needed to create a linked list
	 */
	private class TPNode{
		public Double data;
		public TPNode next;
		public TPNode prev;
		public TPNode prev2;
		/**
		 * Creates a linked node with reference next
		 * as null and data d if d not null
		 * @param  d The value of the double in the node
		 */
		public TPNode(Double d){
			if (d != null)
			{
				data = d;
				next = null;
				prev = null;
				prev2 = null;
			}
		}
		/**
		 * Creates a doubly linked node with references n and Double d
		 * @param  d The Double value in the node
		 * @param  n Reference to the next node
		 * @param  pr Reference to the previous node
		 * @param  pr2 Reference to the prev prev node
		 */
		public TPNode(Double d, TPNode n, TPNode pr, TPNode pr2){
			if (d != null)
			{
				data = d;
				next = n;
				prev = pr;
				prev2 = pr2;
			}
		}
	}
	private TPNode head;
	private TPNode tail;
	private int size;
	/**
	 * Creates an empty list with size 0.
	 */
	public TwoPrevList(){
		head = new TPNode(null);
		tail = head;
		size = 0;
	}
	/**
	 * Adds Double d at position i counting from the head
	 * @param  i Index counting from the head
	 * @param  d Double to add
	 * @return   true if Double succesfully added, false otherwise
	 */
	public boolean add(int i, Double d){
		TPNode track = head;
		if(d == null || i > size || i !=0){ 
			return false;
		}
		if(size == 0){ //case 1, empty list
			addFirst(d);
		} else if (size - 1 == i){
			addLast(d);
		}
		else if(size >= 2) { //case 2, 1 element in list
			TPNode newNode = new TPNode(d, null, null, null);
			TPNode oldNode;
			for(int k = 0; k <= i; k++){
				if(k == i){
					//d = track.data;
					oldNode = track;
					track.next.prev2 = newNode;
					track.prev = newNode;
					track = newNode;
					size++;
				}
				track = track.next;
			}
		}
		//track = head;
		return true;
	}
	/**
	 * Adds a Double to the front of the list
	 * @param  d Double to add
	 * @return   true if the Double has been successfully added, false otherwise
	 */
	public boolean addFirst(Double d){
		if(d == null){ 
			return false;
		}
		if(size == 0){ //case 1, empty list
			head = new TPNode(d, null, null, null);
			tail = head;
			size++;
		} else if(size == 1) { //case 2, 1 element in list
			TPNode newNode = new TPNode(d, head, null, null);
			head.prev = newNode;
			head = newNode;
			size++;
		} else if(size == 2){ //case 3, 2+ nodes in list
			TPNode newNode = new TPNode(d, head, null, null);
			head.prev = newNode;
			tail.prev2 = newNode;
			head = newNode;
			size++;
		} else { //can consolidate
			TPNode newNode = new TPNode(d, head, null, null);
			head.prev = newNode;
			//tail.prev2 = tail.prev.prev;
			head = newNode;
			size++;
		}
		return true;
	}
	/**
	 * Adds a Double to the end of the list.
	 * @param  d Double to add
	 * @return   true if the Double has been successfully added, false otherwise
	 */
	public boolean addLast(Double d){
		if(d == null){
			return false;
		}
			if(size == 0){//case 1, no elements in the list
			tail = new TPNode(d, null, null, null);
			head = tail;
			size++;
		}else if(size == 1) { //case 2, 1 element in list
			TPNode newNode = new TPNode(d, null, tail, null);
			tail.next = newNode;
			tail = newNode;
			tail.prev = head;
			head.next = tail;
			size++;
		} else if(size >= 2){ //case 3, 2+ nodes in list
			TPNode newNode = new TPNode(d, null, tail, null);
			tail.next = newNode;
			tail = newNode;
			tail.prev2 = tail.prev.prev;
			size++;
		}
		return true;
	}
	/**
	 * Returns the Double stored at index i
	 * @param  i the index of the Double
	 * @return The value of the Double at index i or null if not found
	 */
	public Double get(int i){
		if(i >= size){
			return null;
		}
		TPNode newNode = head;
		for(int k = 0; k <= i; k++){
			if(k == i){
				return newNode.data;
			}
			newNode = newNode.next;
		}
		return null;
	}
	/**
	 * Returns the size of the list
	 * @return The size of the list
	 */
	public int size(){
		return size;
	}
	/**
	 * Removes and returns the element at the tail of the list
	 * @return The element at the head of the list or null if no objects in list
	 */
	public Double removeLast(){
		return (remove (size - 1));
	}
	/**
	 * Removes and returns the element at the head of the list
	 * @return The element at the head of the list or null if no objects in list
	 */
	public Double removeFirst(){
		return remove(0);
	}
	/**
	 * Removes and returns the element at index i counting from the head
	 * @param  i The index of the object to be removed counting from the head
	 * @return   The Double at index i or null if not found
	 */
	public Double remove(int i){
		Double d;
		if(i >= size){ 
			return null;
		}
		if(size == 1){ //if there's only one element
			d = head.data;
			head = null;
			tail = null;
			//
		}else if(i == 0){ //if its the first element
			d = head.data;
			head.next.next.prev2 = null;
			head.next.prev = null;
			tail = head;
			size--;
		} else if (i == (size - 1)){//if its the last element
			tail.prev.next = null;
			d = tail.data;
			tail = tail.prev;
			size--;
			return d;
		}else if(size > 1) { 
			TPNode newNode = head;
			for(int k = 0; k <= i; k++){
				if(k == i){
					d = newNode.data;
					newNode.next.next.prev2 = newNode.prev;
					newNode.next.prev = newNode.prev;
					head = newNode.prev;
					size--;
					return d;
				}
				newNode = newNode.next;
			}
		}
		return null;
	}
	public int find(Double d){
		if(size == 0){
			return -1;
		}
		TPNode newNode = head;
		for(int k = 0; k < size; k++){
			if(head.data == d){
				return k;
			}
			newNode = newNode.next;
		}
		return -1;
	}
	/**
	 * Finds the average of the three closest elements to int i
	 * @param i integer with the location of the central element
	 * @return a Double with the value of the average
	 */
	public Double average(int i){ //need cases for dif sizes
		if(get(i)== null){
			return 0.0;
		} else if (get(i + 1) == null){
			return ((get(i) + get(i))/2);
		} else if (get(i + 2) == null){
			return ((get(i) + get(i+1) + get(i+2))/3);
		}
		return null;
	} 
	/**
	 * Prints the elements in the list starting from the head
	 * @return A string with the elements of the list separated by spaces
	 */
	public String toString(){
		TPNode curr = head;
		String ret = "";
		if (size <= 0)
		{
			return "This list is empty.\n";
		}
		while (curr != null)
		{
			ret += curr.data + " ";
			curr = curr.next;
		}
		return ret;
	}
	public static void main(String[] args)
	{
		TwoPrevList l = new TwoPrevList();
		l.addFirst(10.5);
		l.addFirst(11.5);
		l.addFirst(12.5);
		l.addFirst(13.9);
		l.addFirst(118.6);
		l.addFirst(15.3);

		System.out.println("--------------TESTING addFirst--------------");
		System.out.println("Given   : " + l);
		System.out.println("Expected: 15.3 118.6 13.9 12.5 11.5 10.5");

		System.out.println("--------------TESTING add--------------");
		l.add(1, 19.6);
		l.add(4, 28.3);
		System.out.println("Given   : " + l);
		System.out.println("Expected: 15.3 19.6 118.6 13.9 28.3 12.5 11.5 10.5");

		System.out.println("--------------TESTING removeFirst--------------");
		l.removeFirst();
		l.removeFirst();
		System.out.println("Given   : " + l);
		System.out.println("Expected: 118.6 13.9 28.3 12.5 11.5 10.5");

		System.out.println("--------------TESTING remove--------------");
		l.remove(2);
		l.remove(3);
		l.remove(1);
		System.out.println("Given   : " + l);
		System.out.println("Expected: 118.6 12.5 10.5");

		System.out.println("--------------TESTING get--------------");
		System.out.println("Given   : The Double at index 1 is " + l.get(1));
		System.out.println("Expected: The Double at index 1 is 12.5");

		System.out.println("--------------TESTING size--------------");
		System.out.println("Given   : The size of l is " + l.size());
		System.out.println("Expected: The size of l is 3");

		TwoPrevList m = new TwoPrevList();
		m.addLast(10.5);
		m.addLast(11.5);
		m.addLast(12.5);
		m.addLast(13.9);
		m.addLast(118.6);
		m.addLast(15.3);

		System.out.println("--------------TESTING addLast--------------");
		System.out.println("Given   : " + m);
		System.out.println("Expected: 10.5 11.5 12.5 13.9 118.6 15.3");

		System.out.println("--------------TESTING removeLast--------------");
		m.removeLast();
		m.removeLast();
		System.out.println("Given   : " + m);
		System.out.println("Expected: 10.5 11.5 12.5 13.9");

		System.out.println("--------------TESTING get--------------");
		System.out.println("Given   : The Double at index 3 is " + m.get(3));
		System.out.println("Expected: The Double at index 3 is 13.9");

		System.out.println("--------------TESTING size--------------");
		System.out.println("Given   : The size of m is " + m.size());
		System.out.println("Expected: The size of m is 4");
	}
}