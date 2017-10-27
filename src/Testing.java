public class Testing {
	
	public static void main(String[] args) {
		
		/*
		LinkedList<Integer> testList = new LinkedList<Integer>();	
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(2);
		testList.add(1);
		*/
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();
		
		testSet.add(5);
		testSet.add(3);
		testSet.add(2);
		testSet.add(1);
		testSet.add(4);
		testSet.add(10);
		testSet.add(8);
		testSet.add(6);
		testSet.add(7);
		testSet.add(9);
		
		testSet.printTree();
		testSet.toArray();
		
		// NEED TO ADD COMPUTATIONAL COMPLEXITIES TO COMMENTS!
	}

}

// Use Shift+Alt+J to generate javadoc comments