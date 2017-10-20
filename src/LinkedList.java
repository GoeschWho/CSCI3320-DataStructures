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
		while (head != null) {
			System.out.printf("%d ",head.datum);
			head = head.next;
		}
		System.out.println();
	}
	
	@Override
	public void add(T obj) {
		head = add(head, obj);
	}

	private ListNode add(ListNode head, T datum) {
		if (head == null) {
			return new ListNode(datum);
		}
		else {
			head.next = add(head.next, datum);
			return head;
		}
	}

	@Override
	public void add(int idx, T obj) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public T get(int idx) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T obj) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
