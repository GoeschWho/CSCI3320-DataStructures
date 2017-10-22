public class Testing {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();	
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		
		testList.printList();
		
		Integer[] myArray = testList.toArray();
		
		System.out.println(myArray);
	}

}

// Use Shift+Alt+J to generate javadoc comments