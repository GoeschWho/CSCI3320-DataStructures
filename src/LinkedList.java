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
	 * Constructs and empty linked list.
	 */
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Prints the datum of the linked list out in order in the 
	 * console, each separated by a space.
	 */
	public void printList() {
		ListNode current = head;
		while (current != null) {
			System.out.printf("%d ",current.datum);
			current = current.next;
		}
		System.out.println();
	}
	
	/**
     * Adds the specified object to the end of the sequence.
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
	private ListNode add(ListNode head, T datum) {
		if (head == null) {
			return new ListNode(datum);
		}
		else {
			head.next = add(head.next, datum);
			return head;
		}
	}
	
	/**
     * Adds the specified object at the given position in the sequence.
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
		}
		else {
			while (!found) {
				if (n == idx - 1) {
					tmp.next = current.next;
					current.next = tmp;
					found = true;
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
     */
	@Override
	public void clear() {
		head = null;
	}

	/**
     * Returns the object at the specified position in the sequence.
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
	private boolean contains(ListNode head, T datum) {
		if (head == null) {
			return false;
		}
		else if (head.datum == datum) {
			return true;
		}
		else {
			return contains(head.next, datum);
		}
	}

	@Override
	public int indexOf(T obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int idx) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Returns the number of elements in the sequence.
     *
     * @return the number of elements in the sequence
     */
	@Override
	public int size() {
		ListNode current = head;
		int n = 0;
		
		while (current != null) {
			n++;
			current = current.next;
		}
		return n;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
