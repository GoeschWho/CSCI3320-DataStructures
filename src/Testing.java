public class Testing {
	
	public static void main(String[] args) {
		LinkedList<Integer> testList = new LinkedList<Integer>();	
		testList.add(1);
		testList.add(2);
		testList.add(3);
		
		testList.printList();
		
		System.out.println(testList.contains(7));
	}

}

// Use Shift+Alt+J to generate javadoc comments