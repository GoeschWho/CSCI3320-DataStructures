/**
 * This class tests each of the Set interface methods.
 * While the tests cover the basic cases, the exception throwing cases
 * were manually tested individually outside this class along with
 * testing needed for debugging.  This class serves the purpose of
 * making sure nothing got accidentally "broken" after its initial
 * testing and during development.  The final method outputs a GraphViz
 * file at each step during an AVL tree creation to verify balancing.
 * 
 * The {@code result} and {@code compare} methods were created to
 * standardize the testing output.
 * 
 * The {@code test*} methods each test a specific function from the
 * Set interface.
 * 
 * @author Megan Bird
 */
public class Test {
	
	public static void main(String[] args) {
		
		// AVLSet testing
		
		testAVLSetadd();
		testAVLSetclear();
		testAVLSetcontains();
		testAVLSetisEmpty();
		testAVLSetremove();
		testAVLSetsize();
		testAVLSettoArray();
		
		testAVLGraphVizWrite();
		
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
	
	private static void testAVLSetadd() {
		
		AVLSet<Integer> testSet1 = new AVLSet<Integer>();
		AVLSet<Integer> testSet2 = new AVLSet<Integer>();
		
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
		
		result("AVLSet add(T obj)",compare(testSet1.toString(),testSet2.toString()));
	}
	
	private static void testAVLSetclear() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();

		for (int i = 0; i < 10; i++) {
			testSet.add(i);
		}
		
		testSet.clear();
		
		result("AVLSet clear()",compare(testSet.toString(),"{}"));
	}
	
	private static void testAVLSetcontains() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();

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
		
		result("AVLSet contains(T obj)",result);
	}
	
	private static void testAVLSetisEmpty() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();
		
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
		
		result("AVLSet isEmpty()",result);
	}
	
	private static void testAVLSetremove() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();

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
		
		result("AVLSet remove(T obj)",compare(testSet.toString(),"{2, 3, 4, 6, 8, 9}"));
	}
	
	private static void testAVLSetsize() {

		AVLSet<Integer> testSet = new AVLSet<Integer>();
		
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
		
		result("AVLSet size()",result);
	}
	
	private static void testAVLSettoArray() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();
		
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
		
		result("AVLSet toArray()",result);	
	}
	
	private static void testAVLGraphVizWrite() {
		
		AVLSet<Integer> testSet = new AVLSet<Integer>();
		
		testSet.add(10);
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(9);
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(8);		
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(13);
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(12);
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(11);		
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(15);		
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(14);		
		System.out.printf("\n\n%s",testSet.graphvizForm());
		testSet.add(16);		
		System.out.printf("\n\n%s",testSet.graphvizForm());
	}
}