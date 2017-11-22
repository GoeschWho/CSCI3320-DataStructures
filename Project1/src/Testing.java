/**
 * This class tests each of the Set and Sequence interface methods.
 * While the tests cover the basic cases, the exception throwing cases
 * were manually tested individually outside this class along with
 * testing needed for debugging.  This class serves the purpose of
 * making sure nothing got accidentally "broken" after its initial
 * testing and during development.
 * 
 * The {@code result} and {@code compare} methods were created to
 * standardize the testing output.
 * 
 * The {@code test*} methods each test a specific function from the
 * Set and Sequence interfaces.
 * 
 * @author Megan Bird
 */
public class Testing {
	
	public static void main(String[] args) {

		// LinkedList testing
		testLLadd1();
		testLLadd2();
		testLLclear();
		testLLget();
		testLLcontains();
		testLLindexOf();
		testLLisEmpty();
		testLLremove1();
		testLLremove2();
		testLLsize();
		testLLtoArray();
		
		// BinarySearchTree testing
		testBSTadd();
		testBSTclear();
		testBSTcontains();
		testBSTisEmpty();
		testBSTremove();
		testBSTsize();
		testBSTtoArray();
		
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
	
	private static void testLLadd1() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		result("LinkedList add(T obj)",compare(testList.toString(),"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLadd2() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		try {
			testList.add(1,0);
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("Planned IndexOutOfBoundException caught!");
		}
		testList.add(0,0);
		testList.add(1,1);
		testList.add(2,3);
		testList.add(2,2);
		
		result("LinkedList add(int idx, T obj)",compare(testList.toString(),"[0, 1, 2, 3]"));
	}
	
	private static void testLLclear() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.clear();
		
		result("LinkedList clear()",compare(testList.toString(),"[]"));
		
	}

	private static void testLLget() {
		
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
	
	private static void testLLcontains() {

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
	
	private static void testLLindexOf() {
		
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
	
	private static void testLLisEmpty() {
		
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
	
	private static void testLLremove1() {
		
		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.remove(0);
		testList.remove(1);
		
		result("LinkedList remove(int idx)",compare(testList.toString(),"[1, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLremove2() {

		LinkedList<Integer> testList = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testList.add(i);
		}
		
		testList.remove(Integer.valueOf(0));
		testList.remove(Integer.valueOf(2));
		
		result("LinkedList remove(T obj)",compare(testList.toString(),"[1, 3, 4, 5, 6, 7, 8, 9]"));
	}
	
	private static void testLLsize() {
		
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
	
	private static void testLLtoArray() {
		
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

	private static void testBSTadd() {
		
		BinarySearchTree<Integer> testSet1 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> testSet2 = new BinarySearchTree<Integer>();
		
		for (int i = 0; i < 10; i++) {
			testSet1.add(i);
		}
		
		testSet2.add(5);
		testSet2.add(3);
		testSet2.add(8);
		testSet2.add(1);
		testSet2.add(0);
		testSet2.add(2);
		testSet2.add(4);
		testSet2.add(6);
		testSet2.add(7);
		testSet2.add(9);
		
		result("BinarySearchTree add(T obj)",compare(testSet1.toString(),testSet2.toString()));
	}
	
	private static void testBSTclear() {
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();

		for (int i = 0; i < 10; i++) {
			testSet.add(i);
		}
		
		testSet.clear();
		
		result("BinarySearchTree clear()",compare(testSet.toString(),"{}"));
	}
	
	private static void testBSTcontains() {
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();

		String result;
		
		for (int i = 0; i < 10; i++) {
			testSet.add(i);
		}
		
		if (testSet.contains(5) && !testSet.contains(100)) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("BinarySearchTree contains(T obj)",result);
	}
	
	private static void testBSTisEmpty() {
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();
		
		String result;

		for (int i = 0; i < 10; i++) {
			testSet.add(i);
		}
		
		boolean result1 = testSet.isEmpty();
		
		testSet.clear();
		
		if (testSet.isEmpty() && !result1) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("BinarySearchTree isEmpty()",result);
	}
	
	private static void testBSTremove() {
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();

		testSet.add(5);
		testSet.add(3);
		testSet.add(8);
		testSet.add(1);
		testSet.add(0);
		testSet.add(2);
		testSet.add(4);
		testSet.add(6);
		testSet.add(7);
		testSet.add(9);
		
		testSet.remove(Integer.valueOf(1));
		testSet.remove(Integer.valueOf(0));
		testSet.remove(Integer.valueOf(7));
		testSet.remove(Integer.valueOf(5));
		
		result("BinarySearchTree remove(T obj)",compare(testSet.toString(),"{2, 3, 4, 6, 8, 9}"));
	}
	
	private static void testBSTsize() {

		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();
		
		String result;

		for (int i = 0; i < 10; i++) {
			testSet.add(i);
		}
		
		boolean result1 = testSet.size() == 10;
		
		testSet.clear();
		
		if (testSet.size() == 0 && result1) {
			result = "passed";
		}
		else {
			result = "failed";
		}
		
		result("BinarySearchTree size()",result);
	}
	
	private static void testBSTtoArray() {
		
		BinarySearchTree<Integer> testSet = new BinarySearchTree<Integer>();
		
		String result = "passed";
		
		testSet.add(5);
		testSet.add(3);
		testSet.add(8);
		testSet.add(1);
		testSet.add(0);
		testSet.add(2);
		testSet.add(4);
		testSet.add(6);
		testSet.add(7);
		testSet.add(9);
		
		Object[] resultArray = testSet.toArray();
		
		for (int i = 0; i < 10; i++) {
			if ((int)resultArray[i] != i) {
				result = "failed";
				break;
			}
		}
		
		result("BinarySearchTree toArray()",result);	
	}
}