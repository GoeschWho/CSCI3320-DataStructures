/**
 * This class implements the provided Sequence interface.
 * 
 * @author Megan Bird
 *
 * @param <T>
 */
public class LinkedList<T> implements Sequence<T> {
	
	/**
	 * This class defines a node of a linked list.
	 * 
	 * @author Megan Bird
	 */
	class ListNode {
		T datum;
		ListNode next;
		
		/**
		 * Constructs an empty node.
		 * 
		 * @param datum
		 */
		ListNode(T datum) {
			this.datum = datum;
			this.next = null;
		}
	}
	
	/**
	 * Holds the node designated as the head of the linked list.
	 */
	private ListNode head;
	
	/**
	 * Holds the number of elements in the list.
	 */
	private int size;
	
	/**
	 * Constructs and empty linked list.
	 */
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * Prints the datum of the linked list out in order in the console.
	 * 
	 * O(n):  {@code toString} iterates through entire linked list.
	 */
	public void printList() {
		System.out.println(toString());
	}
	
	/**
	 * Return a {@code String} representation of the linked list.
	 * 
	 * O(n):  Iterates through entire linked list.
	 *
	 * @return a {@code String} representation of the linked list.
	 * @author Provided via Canvas
	 */
	public String toString() {
	    StringBuilder repr = new StringBuilder();
	    repr.append("[");

	    ListNode tmp = head;
	    if (tmp != null) {
	        repr.append(tmp.datum);
	        do {
	            tmp = tmp.next;
	            if (tmp != null) {
	                repr.append(", ").append(tmp.datum);
	            }
	        } while (tmp != null);
	    }

	    repr.append("]");

	    return repr.toString();
	}
	
	/**
     * Adds the specified object to the end of the sequence.
     * 
     * O(n):  {@code private add()} iterates
     * 		through the entire linked list.
     *
     * @param obj Object to be appended to this sequence
     */
	@Override
	public void add(T obj) {
		head = add(head, obj);
	}

	/**
	 * Recursively implements the public add to end operation
	 * 
	 * @param head Linked list to be added to
	 * @param datum Data to be added to the list
	 * @return Returns the resulting list
	 */
	private ListNode add(ListNode current, T datum) {
		if (current == null) {
			size++;
			return new ListNode(datum);
		}
		else {
			current.next = add(current.next, datum);
			return current;
		}
	}
	
	/**
     * Adds the specified object at the given position in the sequence.
     * 
     * O(n):  Iterates through linked list until index.
     *
     * @param idx index at which the specified object is to be inserted
     * @param obj object to be appended to this sequence
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
	@Override
	public void add(int idx, T obj) throws IndexOutOfBoundsException {
		boolean found = false;
		int n = 0;
		ListNode tmp = new ListNode(obj);
		ListNode current = head;
		
		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}
		else if (idx == 0) {
			tmp.next = head;
			head = tmp;
			size++;
		}
		else {
			while (!found) {
				if (n == idx - 1) {
					tmp.next = current.next;
					current.next = tmp;
					found = true;
					size++;
				}
				else {
					current = current.next;
					n++;
				}
			}
		}
	}

	/**
     * Removes all of the elements from the sequence.
     * 
     * O(1):  Not dependent on list size.
     */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
     * Returns the object at the specified position in the sequence.
     * 
     * O(n):  Iterates through linked list until index.
     *
     * @param idx index of the element to return
     * @return the object at the specified position in the sequence
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
	@Override
	public T get(int idx) throws IndexOutOfBoundsException {
		boolean found = false;
		int n = 0;
		ListNode current = head;
		
		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			while (!found) {
				if (n == idx) {
					found = true;
					return current.datum;
				}
				else {
					current = current.next;
					n++;
				}
			}
		}
		return null; // Due to index checking, this should never be reached.
	}

	/**
     * Returns {@code true} if the sequence contains the specified object and
     * {@code false} otherwise.
     * 
     * O(n):  {@code private contains()} iterates
     * 		through the linked list.
     *
     * @param obj the object to find in the sequence
     * @return {@code true} if the sequence contains the specified object and
     *         {@code false} otherwise
     */
	@Override
	public boolean contains(T obj) {
		return contains(head, obj);
	}
	
	/**
	 * Recursively implements the public contains function. 
	 * 
	 * @param head The head of the linked list to look in
	 * @param datum The data to look for
	 * @return {@code true} if the linked list contains the data
     *         {@code false} otherwise
	 */
	private boolean contains(ListNode current, T datum) {
		if (current == null) {
			return false;
		}
		else if (current.datum == datum) {
			return true;
		}
		else {
			return contains(current.next, datum);
		}
	}

	/**
     * Returns the index of the first occurrence of the specified object in
     * this sequence, or -1 if object is not present.
     * 
     * O(n):  Iterates through linked list until object found.
     *
     * @param obj the object to find in the sequence
     * @return the index of the first occurrence of the specified object in
     *         this sequence, or -1 if object is not present
     */
	@Override
	public int indexOf(T obj) {
		int n = 0;
		ListNode current = head;
		
		while (current != null) {
			if (current.datum == obj) {
				return n;
			}
			else {
				current = current.next;
				n++;
			}
		}
		return -1;
	}

	/**
     * Returns {@code true} if the sequence is empty and {@code false}
     * otherwise.
     * 
     * O(1):  Not dependent on list size.
     *
     * @return {@code true} if the sequence is empty and {@code false}
     *         otherwise
     */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
     * Removes the object at the specified position in the sequence.
     * 
     * O(n):  Iterates through list until index.
     *
     * @param idx index of the element to remove
     * @return the object previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index > size())
     */
	@Override
	public T remove(int idx) throws IndexOutOfBoundsException {
		int n = 0;
		boolean found = false;
		ListNode current = head;
		ListNode retNode = null;
		
		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}
		else if (idx == 0) {
			retNode = current;
			head = current.next;
			size--;
		}
		else {
			while (!found) {
				if (n == idx - 1) {
					retNode = current.next;
					current.next = current.next.next;
					found = true;
					size--;
				}
				else {
					current = current.next;
					n++;
				}
			}
		}
		return retNode.datum;
	}

	/**
     * Remove the first occurrence of the specified object from the sequence,
     * if it is present.
     * 
     * O(n):  Iterates through the list until object found.
     *
     * @param obj the object to remove
     * @return {@code true} if the sequence contained the specified object and
     *         {@code false} otherwise
     */
	@Override
	public boolean remove(T obj) {
		int startSize = size;
		head = remove(head, obj);
		if (size != startSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Recursively implements the public remove function. 
	 * 
	 * @param head The head of the linked list to look in
	 * @param datum The data to look for
	 * @return Resulting list after removal.
	 */
	private ListNode remove(ListNode current, T datum) {
		if (current != null) {
			if (current.datum == datum) {
				current = current.next;
				size--;
			}
			else {
				current.next = remove(current.next, datum);
			}
		}
		return current;
	}

	/**
     * Returns the number of elements in the sequence.
     * 
     * O(1):  Complexity not dependent on list size.
     *
     * @return the number of elements in the sequence
     */
	@Override
	public int size() {
		return size;
	}

	/**
     * Returns an array containing all of the elements in the sequence in the
     * proper order (from first to last).
     * 
     * O(n):  Iterates through the entire list.
     *
     * @return an array containing the elements of the sequence
     */
	@Override
	public Object[] toArray() {
		if (isEmpty()) {
	        return null;
	    }

		Object[] data = new Object[size()];

	    ListNode tmp = head;
	    for (int i = 0; i < size(); i++) {
	        data[i] = tmp.datum;
	        tmp = tmp.next;
	    }

	    return data;		
	}

}
