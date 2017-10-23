public class Testing {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();	
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(2);
		testList.add(1);
		
		testList.printList();
		
		// need to check that remove(obj) removes the FIRST instance
		System.out.println(testList.remove(Integer.valueOf(2)));
		
		testList.printList();		
		
		//Object[] myArray = testList.toArray();
		
		//System.out.println(myArray);
		
		
		// NEED TO ADD COMPUTATIONAL COMPLEXITIES TO COMMENTS!
	}

}

// Use Shift+Alt+J to generate javadoc comments