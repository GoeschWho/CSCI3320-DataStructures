/**
 * @author Megan Bird
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(8);
		tree.add(3);
		tree.add(4);
		tree.add(15);
		tree.add(20);
		tree.add(13);
		tree.add(18);
		
		System.out.print(tree.graphvizForm());
	}

}
