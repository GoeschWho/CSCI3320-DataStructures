/**
 * This class implements the provided Set interface.
 * 
 * @author Megan Bird
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Set<T> {
	
	/**
	 * This class defines a node of a binary tree;
	 * 
	 * @author Megan Bird
	 */
	class TreeNode {
		T datum;
		TreeNode left;
		TreeNode right;
		
		/**
		 * Constructs an empty TreeNode
		 * 
		 * @param datum
		 */
		TreeNode(T datum) {
			this.datum = datum;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * Holds the node designated as the root of the BST;
	 */
	private TreeNode root;
	
	/**
	 * Holds the size of the BST;
	 */
	private int size;
	
	/**
	 * Constructs and empty BST;
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * Prints the datum of the BST out in order in the console.
	 */
	public void printTree() {
		System.out.println(toString());
	}
	
	/**
	 * Adapted from the provided toString() for a linked list.
	 * Return a {@code String} representation of the BST.
	 * 
	 * @return a {@code String} representation of the BST.
	 * @author Adapted from Canvas source
	 */
	public String toString() {
		StringBuilder repr = new StringBuilder();
	    repr.append("{");

	    TreeNode tmp = root;
	    if (root != null) {
	    	repr.append(toString(tmp).substring(2));
	    }

	    repr.append("} Size: ");
	    repr.append(size);

	    return repr.toString();
	}
	
	/**
	 * Return a string of the BST contents.
	 * 
	 * @param current
	 * @return a {@code String} representation of the BST contents.
	 */
	private String toString(TreeNode current) {
		StringBuilder repr = new StringBuilder();
		
	    if (current != null) {
	    	repr.append(toString(current.left));
	    	repr.append(", ").append(current.datum);
	    	repr.append(toString(current.right));
	    }
	    
	    return repr.toString();
	}
	
	/**
     * Adds the specified object to the set.
     *
     * @param obj object to be added to the set
     */
	@Override
	public void add(T obj) {
		root = add(root, obj);		
	}
	
	/**
	 * Recursively implements the public add operation.
	 * 
	 * @param head Tree to be added to
	 * @param obj Object to add to tree
	 * @return Tree reseulting from the add
	 */
	private TreeNode add(TreeNode current, T obj) {
		if (current == null) {
			size++;
			return new TreeNode(obj);
		}
		else if (current.datum == obj) {
			return current;
		}
		else {
			int comparison = obj.compareTo(current.datum);
			
			if (comparison > 0) {
				current.right = add(current.right, obj);
				return current;
			}
			else if (comparison < 0) {
				current.left = add(current.left, obj);
				return current;
			}
		}
		return current;
	}

	/**
     * Removes all of the elements from the set.
     */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	/**
     * Returns {@code true} if the set contains the specified object and
     * {@code false} otherwise.
     *
     * @param obj the object to find in the set
     * @return {@code true} if the set contains the specified object and
     *         {@code false} otherwise
     */
	@Override
	public boolean contains(T obj) {
		return contains(root, obj);
	}
	
	/**
	 * Recursively implements the public contains function.
	 * 
	 * @param current The tree to be searched in.
	 * @param obj The object to look for.
	 * @return {@code true} if the set contains the specified object and
     *         {@code false} otherwise
     * @author Adapted from Figure 4.18 in the textbook.
	 */
	private boolean contains(TreeNode current, T obj) {
		if (current == null) {
			return false;
		}
		
		int comparison = obj.compareTo(current.datum);
		
		if (comparison < 0) {
			return contains(current.left, obj);
		}
		else if (comparison > 0) {
			return contains(current.right, obj);
		}
		else {
			return true;
		}
	}

	/**
     * Returns {@code true} if the set is empty and {@code false} otherwise.
     *
     * @return {@code true} if the set is empty and {@code false} otherwise
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

	@Override
	public void remove(T obj) {
		// TODO Auto-generated method stub

	}

	/**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
	@Override
	public int size() {
		return size;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
