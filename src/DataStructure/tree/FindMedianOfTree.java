package DataStructure.tree;

import java.util.ArrayList;

public class FindMedianOfTree {
	public static void main(String args[]) {
		MyBinarySearchTree<Integer> binaryTree = new MyBinarySearchTree<Integer>();
		binaryTree.insertNode(6);
		binaryTree.insertNode(3);
		binaryTree.insertNode(1);
		binaryTree.insertNode(4);
		binaryTree.insertNode(8);
		binaryTree.insertNode(7);
		//binaryTree.insertNode(9);
		ArrayList<Integer> inorder = binaryTree.inorderTraversing();
		if (inorder.size() % 2 == 0) {
			int firstElement = inorder.get((inorder.size() % 2)+2);
			int secondElement = inorder.get((inorder.size() % 2) + 3);
			System.out.println("Median of Bindary Tree is even(" + firstElement + " + " + secondElement + ") :=>"
					+ (firstElement + secondElement) / 2);
		} else {
			System.out.println("Median of Bindary Tree is odd :=>" + inorder.get((inorder.size() % 2) + 2));
		}
	}
}
