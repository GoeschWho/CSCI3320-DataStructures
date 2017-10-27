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
		
		testSet.add(1);
		testSet.add(2);
		testSet.add(3);
		testSet.add(4);
		testSet.add(5);
		
		testSet.printTree();
		
		System.out.println(testSet.size());
		
		System.out.println(testSet.isEmpty());
		
		testSet.clear();
		
		testSet.printTree();
		
		System.out.println(testSet.size());
		
		System.out.println(testSet.isEmpty());
		
		
		// NEED TO ADD COMPUTATIONAL COMPLEXITIES TO COMMENTS!
	}

}

// Use Shift+Alt+J to generate javadoc comments