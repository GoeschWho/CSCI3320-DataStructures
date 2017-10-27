import java.util.Stack;

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
	 * This class defines an iterator for a BST.
	 * 
	 * @author Megan Bird
	 */
	class Iterator {
		
		/**
		 * This class defines a stack for TreeNode objects,
		 * implemented as a linked list.
		 * 
		 * @author Megan Bird
		 */
		class Stack {
			/**
			 * This class defines a stack element, which is
			 * the node of the stack linked list.
			 * 
			 * @author Megan Bird
			 */
			class StackElement {
				TreeNode datum;
				StackElement next;
				
				/**
				 * Constructs an empty stack element (list node)
				 * 
				 * @param datum
				 */
				StackElement(TreeNode datum) {
					this.datum = datum;
					this.next = null;
				}
			}
			
			/**
			 * Stores the top of the stack (head of linked list).
			 */
			private StackElement head;
			
			/**
			 * Constructs an empty stack (empty linked list).
			 */
			public Stack() {
				head = null;
			}
			
			/**
			 * Performs a stack push operation by prepending a node
			 * to the head of the underlying linked list.
			 * 
			 * @param node
			 */
			public void push(TreeNode node) {
				StackElement tmp = new StackElement(node);
				tmp.next = head;
				head = tmp;
			}
			
			/**
			 * Performs a stack pop operation by removing and returning
			 * the head of the underlying linked list.
			 * 
			 * @return
			 */
			public TreeNode pop() {
				TreeNode tmp = head.datum;
				head = head.next;
				return tmp;
			}
		}
		
		private Stack stack = new Stack();
		
		/**
		 * Creates an iterator object for the tree using the root.
		 * 
		 * @param root
		 */
		public Iterator(TreeNode root) {
			pushLeft(root);
		}

		/**
		 * Returns the next node of the BST using the stack.
		 * 
		 * @return The next node in the BST.
		 */
		public TreeNode next() {
			TreeNode tmp = stack.pop();
			if (tmp.right != null) {
				pushLeft(tmp.right);
			}
			return tmp;
		}
		
		/**
		 * Pushes the left most node of the BST onto the stack.
		 * 
		 * @param tmp BST to use.
		 */
		public void pushLeft(TreeNode tmp) {
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
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

	/**
     * Remove the specified object from the set, if it is present.
     *
     * @param obj the object to remove
     * @return {@code true} if the set contained the specified object and
     *         {@code false} otherwise
     */
	@Override
	public boolean remove(T obj) {
		int startSize = size;
		root = remove(root, obj);
		if (size != startSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Recursively implements the public remove method.
	 * 
	 * @param current BST to look in.
	 * @param obj The object to remove.
	 * @return Resulting BST after removal.
	 */
	private TreeNode remove(TreeNode current, T obj) {
		if (current == null) {
			return current;
		}
		
		int comparison = obj.compareTo(current.datum);
		
		if (comparison < 0) {
			current.left = remove(current.left, obj);
		}
		else if (comparison > 0) {
			current.right = remove(current.right, obj);
		}
		else if (comparison == 0) {
			if(isLeaf(current)) {
				current = null;
				size--;
			}
			else if (current.left != null && current.right == null) {
				current = current.left;
				size--;
			}
			else if (current.left == null && current.right != null) {
				current = current.right;
				size--;
			}
			else {
				TreeNode max = maximum(current.left);
				current.datum = max.datum;
				max.datum = obj;
				current.left = remove(current.left, obj);
			}
		}
		return current;
	}
	
	/**
	 * Determines if a BST node is a leaf.
	 * 
	 * @param tmp Node to analyze
	 * @return {@code true} if the node has no children
     *         {@code false} otherwise
	 */
	private boolean isLeaf(TreeNode tmp) {
		if (tmp.left == null && tmp.right == null) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Return the maximum node in a BST.
	 * Adapted from Figure 4.20 in the textbook.
	 * 
	 * @param current Root of tree to look in.
	 * @return Node with the maximum value.
	 * @author Adapted from Figure 4.20 in the textbook.
	 */
	private TreeNode maximum(TreeNode current) {
		if (current != null) {
			while( current.right != null) {
				current = current.right;
			}
		}
		return current;
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

	/**
     * Returns an array containing all of the objects in the set in the proper
     * order (from least to greatest).
     *
     * @return an array containing the objects in the set
     */
	@Override
	public Object[] toArray() {
		if (isEmpty()) {
	        return null;
	    }

		Object[] data = new Object[size()];
		Iterator iTree = new Iterator(root);

	    for (int i = 0; i < size(); i++) {
	        data[i] = iTree.next();
	    }
	    
	    /* Print for testing
	    for (int i = 0; i < data.length; i++) {
	    	System.out.println(((TreeNode) data[i]).datum);
	    }
	    */
	    
	    return data;
	}

}
