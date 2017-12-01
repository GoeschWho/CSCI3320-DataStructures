/**
 * This class implements the provided Set interface with AVL trees.
 * 
 * @author Megan Bird
 *
 * @param <T>
 */
public class AVLSet<T extends Comparable<T>> implements Set<T>, GraphVizWriteable {

	/**
	 * This class defines a node of a binary tree;
	 * 
	 * @author Megan Bird
	 */
	class TreeNode {
		T datum;
		int height;
		TreeNode left;
		TreeNode right;
		
		/**
		 * Constructs an new TreeNode
		 * 
		 * @param datum
		 */
		TreeNode(T datum) {
			this.datum = datum;
			this.height = 0;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * This class defines an iterator for a tree.
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
		 * Returns the next node of the tree using the stack.
		 * 
		 * @return The next node in the tree.
		 */
		public TreeNode next() {
			TreeNode tmp = stack.pop();
			if (tmp.right != null) {
				pushLeft(tmp.right);
			}
			return tmp;
		}
		
		/**
		 * Pushes the left most node of the tree onto the stack.
		 * 
		 * @param tmp tree to use.
		 */
		public void pushLeft(TreeNode tmp) {
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
		}
	}
	
	/**
	 * Holds the node designated as the root of the tree;
	 */
	private TreeNode root;
	
	/**
	 * Holds the number of nodes of the tree;
	 */
	private int size;
	
	/**
	 * Constructs and empty AVLSet
	 */
	public AVLSet() {
		root = null;
		size = 0;
	}
	
	/**
	 * Returns the affective height of a node which is simple the node
	 * height value or -1 when a null node.
	 * 
	 * @param node to check height of
	 * @return height of node
	 */
	private int height(TreeNode node) {
		if (node == null) {
			return -1;
		}
		else {
			return node.height;
		}
	}
	
	/**
	 * Updates the height of given node based on heights of its children.
	 * Height of children must already be updated as this function does
	 * not update the children recursively.  It is to be called
	 * while a recursive function is returning up the tree.
	 * 
	 * @param current Node to update height of
	 */
	private TreeNode updateHeight(TreeNode current) {
		if (isLeaf(current)) {
			current.height = 0;
		}
		else if (current.left != null && current.right == null) {
			current.height = 1 + current.left.height;
		}
		else if (current.left == null && current.right != null) {
			current.height = 1 + current.right.height;
		}
		else {
			current.height = 1 + Math.max(current.left.height, current.right.height);
		}
		return current;
	}
	
	/**
	 * Balances the tree from the perspective of the given node.
	 * This is done by determining the scenario and performing
	 * either left or right rotations.
	 * 
	 * @param current node to balance at
	 * @return balanced tree
	 */
	private TreeNode balance(TreeNode current) {
		if (height(current.left) - height(current.right) > 1) { // scenario 1 or 2
			if (height(current.left.left) >= height(current.left.right)) { // scenario 1 - single right rotation
				current = rightRotation(current);
			}
			else { // scenario 2 - double rotation - left then right
				current.left = leftRotation(current.left);
				current = rightRotation(current);
			}
		}
		else if (height(current.right) - height(current.left) > 1){ // scenario 3 or 4
			if (height(current.right.right) >= height(current.right.left)) { // scenario 4 - single left rotation
				current = leftRotation(current);
			}
			else { // scenario 3 - double rotation - right then left
				current.right = rightRotation(current.right);
				current = leftRotation(current);
			}
		}
		return current;
	}
	
	/**
	 * Performs a right rotation at the current node for balancing
	 * 
	 * @param current node to perform rotation at
	 * @return resulting node after rotation
	 */
	private TreeNode rightRotation(TreeNode current) {
		TreeNode rt = current.left;
		if (current.left.right != null) {
			current.left = current.left.right;
		}
		else {
			current.left = null;
		}
		rt.right = current;
		updateHeight(rt.right);
		updateHeight(rt);
		return rt;
	}
	
	/**
	 * Performs a left rotation at the current node for balancing
	 * 
	 * @param current node to perform rotation at
	 * @return resulting node after rotation
	 */
	private TreeNode leftRotation(TreeNode current) {
		TreeNode rt = current.right;
		if (current.right.left != null) {
			current.right = current.right.left;
		}
		else {
			current.right = null;
		}
		rt.left = current;
		updateHeight(rt.left);
		updateHeight(rt);
		return rt;
	}
	
	/**
	 * Prints the datum of the tree out in order in the console.
	 * 
	 * O(n):  {@code toString()} iterates through entire tree.
	 */
	public void printTree() {
		System.out.println(toString());
	}
	
	/**
	 * Adapted from the provided toString() for a linked list.
	 * Return a {@code String} representation of the BST.
	 * 
	 * O(n):  Iterates through entire tree.
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

	    repr.append("}");

	    return repr.toString();
	}	
	
	/**
	 * Return a string of the tree contents.
	 * 
	 * @param current
	 * @return a {@code String} representation of the BST contents.
	 */
	private String toString(TreeNode current) {
		StringBuilder repr = new StringBuilder();
		
	    if (current != null) {
	    	repr.append(toString(current.left));
	    	repr.append(", ").append(current.datum);
	    	//repr.append("-").append(current.height); // testing
	    	repr.append(toString(current.right));
	    }
	    
	    return repr.toString();
	}
	
	/**
     * Adds the specified object to the set.
     * 
     * O(n):  Would iterate through entirely single branched trees like a list.
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
	 * @return Tree resulting from the add
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
				current = updateHeight(current);
				current = balance(current);
				current = updateHeight(current);
				return current;
			}
			else if (comparison < 0) {
				current.left = add(current.left, obj);
				current = updateHeight(current);
				current = balance(current);
				current = updateHeight(current);
				return current;
			}
		}
		return current;
	}

	/**
     * Removes all of the elements from the set.
     * 
     * O(1):  Complexity not dependent on tree size.
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
     * O(n):  Would iterate through entirely single branched trees like a list.
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
     * O(1):  Complexity not dependent on tree size.
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
     * O(n):  Would iterate through entirely single branched trees like
     * 		a list to find the node to remove.  In the most complex case
     * 		of removal it would also have to iterate through the provided
     * 		sub-tree to remove the swapped value.
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
	 * @param current tree to look in.
	 * @param obj The object to remove.
	 * @return Resulting tree after removal.
	 */
	private TreeNode remove(TreeNode current, T obj) {
		if (current == null) {
			return current;
		}
		
		int comparison = obj.compareTo(current.datum);
		
		if (comparison < 0) {
			current.left = remove(current.left, obj);
			current = updateHeight(current);
			current = balance(current);
			current = updateHeight(current);
		}
		else if (comparison > 0) {
			current.right = remove(current.right, obj);
			current = updateHeight(current);
			current = balance(current);
			current = updateHeight(current);
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
	 * Determines if a node is a leaf.
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
	 * Return the maximum node in a tree.
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
     * O(1):  Not dependent on tree size.
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
     * O(n):  Would iterate through entirely left single branched trees like
     * 		a list.  The body (for loop) of the method would then also iterate
     * 		through the entire array.
     *
     * @return an array containing the objects in the set
     */
	@Override
	public Object[] toArray() {
		if (isEmpty()) {
	        return null;
	    }

		Object[] data = new Object[size];
		Iterator iTree = new Iterator(root);

	    for (int i = 0; i < size; i++) {
	        data[i] = iTree.next().datum;
	    }
	    
	    /* Print for testing
	    for (int i = 0; i < data.length; i++) {
	    	System.out.println(((TreeNode) data[i]).datum);
	    }
	    */
	    
	    return data;
	}
	
	/**
     * Returns the GraphViz dot file representation of the calling object.
     *
     * @return the GraphViz dot file representation of the calling object
     * 
     * @author Gregory Gelfond (ggelfond@unomaha.edu)
     */
    public String graphvizForm() {
        return graphvizForm(root);
    }

    /**
     * Generates a string containing the GraphVis representation of the tree
     * 
     * @author Gregory Gelfond (ggelfond@unomaha.edu)
     * 
     * @param t tree to output
     * @return string of GraphVis format
     */
    private String graphvizForm(TreeNode t) {
        StringBuilder repr = new StringBuilder();

        repr.append("digraph G {\n");
        repr.append("graph [ dpi = 70 ]\n");
        repr.append("nodesep=0.3;\n");
        repr.append("ranksep=0.2;\n");
        repr.append("margin=0.1;\n");
        repr.append("node [shape=circle];\n");
        repr.append("edge [arrowsize=0.8];\n");

        StringBuilder content = graphvizForm(new StringBuilder(), t, 1);

        repr.append(content);
        repr.append("}");

        return repr.toString();
    }
    
	/**
     * @author Gregory Gelfond (ggelfond@unomaha.edu)
     */
    private StringBuilder graphvizForm(StringBuilder repr, TreeNode t, int base) {
        // if the given tree is empty, do nothing
        if (t == null) {
            return repr;
        }

        // Add to the representation the datum associated with the given node
        //repr.append(String.format("node%d [label=\"%s\"];\n", base, t.datum));
        repr.append(String.format("node%d [label=\"%s-%s\"];\n", base, t.datum, t.height));	// height testing

        // enumerate the left and right subtrees
        int left = 2 * base;
        int right = 2 * base + 1;

        // add the content of the left subtree to our representation
        if (t.left != null) {
            repr.append(String.format("node%d -> node%d;\n", base, left));
            graphvizForm(repr, t.left, left);
        }

        // add the content of the right subtree to our representation
        if (t.right != null) {
            repr.append(String.format("node%d -> node%d;\n", base, right));
            graphvizForm(repr, t.right, right);
        }

        return repr;
    }

}
