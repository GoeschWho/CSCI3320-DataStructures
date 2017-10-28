public class Testing {
	
	public static void main(String[] args) {
		
		/*	
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();
		*/
		
		testLLAdd1();
		testLLAdd2();
		testLLClear();
		testLLGet();
		testLLContains();
		testLLIndexOf();
		testLLIsEmpty();
		testLLRemove1();
		testLLRemove2();
		testLLSize();
		testLLToArray();
		
	}
	
	private static String compare(String result, String expected) {
		
		int cmp = expected.compareTo(result);
		
		if (cmp == 0) {
			return "passed";
		}
		else {
			return "failed";
		}
	}
	
	private static void result(String method, String result) {
		
		if (result == "passed") {
			System.out.printf("%s test %s :D\n",method,result);
		}
		else {
			System.out.printf("*** %s test %s :O\n",method,result);
		}
		
	}
	
	private static void testLLAdd1() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		result("LinkedList add(T obj)",compare(testList.toString(),"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLAdd2() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		try {
			testList.add(1,0);
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundException caught!");
		}
		testList.add(0,0);
		testList.add(1,1);
		testList.add(2,3);
		testList.add(2,2);
		
		result("LinkedList add(int idx, T obj)",compare(testList.toString(),"[0, 1, 2, 3]"));
	}
	
	private static void testLLClear() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.clear();
		
		result("LinkedList clear()",compare(testList.toString(),"[]"));
		
	}

	private static void testLLGet() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result;
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		if (testList.get(4) == 4) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("LinkedList get()",result);
		
	}
	
	private static void testLLContains() {

		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result;
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		if (testList.contains(4) == true && testList.contains(100) == false) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("LinkedList contains(T obj)",result);
	}
	
	private static void testLLIndexOf() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result;
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		if (testList.indexOf(3) == 3 && testList.indexOf(100) == -1) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("LinkedList indexOf(T obj)",result);
	}
	
	private static void testLLIsEmpty() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result;
		boolean firstTest = testList.isEmpty();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		if (firstTest && !testList.isEmpty()) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("LinkedList isEmpty()",result);
	}
	
	private static void testLLRemove1() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.remove(0);
		testList.remove(1);
		
		result("LinkedList remove(int idx)",compare(testList.toString(),"[1, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLRemove2() {

		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.remove(Integer.valueOf(0));
		testList.remove(Integer.valueOf(2));
		
		result("LinkedList remove(T obj)",compare(testList.toString(),"[1, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLSize() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result;
		boolean firstTest;
		
		if (testList.size() == 0) {
			firstTest = true;
		}
		else {
			firstTest = false;
		}
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		if (firstTest && testList.size() == 10) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("LinkedList size()",result);
	}
	
	private static void testLLToArray() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		String result = "passed";
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		Object[] resultArray = testList.toArray();
		
		
		for (int i = 0; i < 10; i++) {
			if ((int)resultArray[i] != i) {
				result = "failed";
				break;
			}
		}
		
		result("LinkedList toArray()",result);		
	}
}

// Use Shift+Alt+J to generate javadoc comments