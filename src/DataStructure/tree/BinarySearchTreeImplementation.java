package DataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImplementation<T> {
	public static void main(String args[]) {
		MyBinarySearchTree<Integer> binaryTree = new MyBinarySearchTree<Integer>();
		binaryTree.insertNode(10);
		binaryTree.insertNode(1);
		binaryTree.insertNode(5);
		binaryTree.insertNode(7);
		binaryTree.insertNode(2);
		binaryTree.insertNode(0);
		binaryTree.insertNode(17);
		binaryTree.insertNode(12);
		binaryTree.insertNode(11);

		binaryTree.inorderTraversing();

		binaryTree.preorderTraversing();

		binaryTree.postorderTraversing();
		
		binaryTree.levelOrderTraversal();
		
		binaryTree.deleteNode(7);
		binaryTree.inorderTraversing();
		System.out.println("\nSize of Tree:=>" + binaryTree.size());

	}
}

class MyBinarySearchTree<T> {
	private int sizeOfTree = 0;
	private TreeNode<T> rootNode;
	private ArrayList<Integer> inorderNode;
	private ArrayList<Integer> preorderNode;
	private ArrayList<Integer> postorderNode;

	public void insertNode(int item) {
		if (rootNode == null) {
			rootNode = new TreeNode<T>(null, item, null);
		} else {
			if (item < rootNode.getData()) {
				rootNode.setLeft(insertTreeNode(rootNode.getLeft(), item));
			} else if (item > rootNode.getData()) {
				rootNode.setRight(insertTreeNode(rootNode.getRight(), item));
			}
		}
		sizeOfTree++;
	}

	public void deleteNode(int item) {
		if (rootNode == null) {
			System.out.println("No element in an Tree");
		} else if (item < rootNode.getData()) {
			rootNode.setLeft(delteTreeNode(rootNode.getLeft(), item));
		} else if (item > rootNode.getData()) {
			rootNode.setRight(delteTreeNode(rootNode.getRight(), item));
		} else {
			// Element Found
			rootNode = null;
		}
		sizeOfTree--;
	}

	private TreeNode<T> delteTreeNode(TreeNode<T> rootNode, int item) {
		TreeNode<T> temp;
		if (rootNode == null) {
			System.out.println("No element in an Tree");
		} else if (item < rootNode.getData()) {
			rootNode.setLeft(delteTreeNode(rootNode.getLeft(), item));
		} else if (item > rootNode.getData()) {
			rootNode.setRight(delteTreeNode(rootNode.getRight(), item));
		} else {
			if (rootNode.getLeft() == null) 
                return rootNode.getRight(); 
            else if (rootNode.getRight() == null) 
                return rootNode.getLeft(); 
			rootNode.setData(findMin(rootNode.getRight()).getData()); 
			rootNode.setRight(delteTreeNode(rootNode.getRight(), rootNode.getData())); 
		}
		return rootNode;
	}

	public TreeNode<T> findMin(TreeNode<T> rootNode) {
		if (rootNode == null) {
			return null;
		} else {
			if (rootNode.getLeft() == null) {
				return null;
			} else {
				return findMin(rootNode.getLeft());
			}
		}
	}

	public TreeNode<T> findMax(TreeNode<T> rootNode) {
		if (rootNode == null) {
			return null;
		} else {
			if (rootNode.getRight() == null) {
				return null;
			} else {
				return findMax(rootNode.getRight());
			}
		}
	}

	private TreeNode<T> insertTreeNode(TreeNode<T> rootNode, int item) {
		if (rootNode == null) {
			rootNode = new TreeNode<T>(null, item, null);
		} else {
			if (item < rootNode.getData()) {
				rootNode.setLeft(insertTreeNode(rootNode.getLeft(), item));
			} else if (item > rootNode.getData()) {
				rootNode.setRight(insertTreeNode(rootNode.getRight(), item));
			}
		}
		return rootNode;
	}

	public TreeNode<T> searchNode(T item) {
		return null;
	}

	public void deleteNode() {
		sizeOfTree--;
	}

	public int size() {
		return sizeOfTree;
	}

	public ArrayList<Integer> preorderTraversing() {
		System.out.print("\nPreOrder:=>");
		preorderNode = new ArrayList<Integer>();
		preOrder(this.rootNode);
		return preorderNode;
	}

	private void preOrder(TreeNode<T> rootNode) {
		// RootLR
		if (rootNode != null) {
			System.out.print(rootNode.getData() + " ");
			preorderNode.add(rootNode.getData());
			preOrder(rootNode.getLeft());
			preOrder(rootNode.getRight());
		}
	}

	public ArrayList<Integer> inorderTraversing() {
		System.out.print("\nInOrder:=>");
		inorderNode = new ArrayList<Integer>();
		inOrder(this.rootNode);
		return inorderNode;
	}

	private void inOrder(TreeNode<T> rootNode) {
		// LRootR
		if (rootNode != null) {
			inOrder(rootNode.getLeft());
			System.out.print(rootNode.getData() + " ");
			inorderNode.add(rootNode.getData());
			inOrder(rootNode.getRight());
		}
	}

	public ArrayList<Integer> postorderTraversing() {
		System.out.print("\nPostOrder:=>");
		postorderNode = new ArrayList<Integer>();
		postOrder(this.rootNode);
		return postorderNode; 
	}

	private void postOrder(TreeNode<T> rootNode) {
		// LRRoot
		if (rootNode != null) {
			postOrder(rootNode.getLeft());
			postOrder(rootNode.getRight());
			System.out.print(rootNode.getData() + " ");
			postorderNode.add(rootNode.getData());
		}
	}
	
	public void levelOrderTraversal() {
		if(rootNode == null) {
			return;
		}
		TreeNode<T> temp = rootNode;
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(temp);
		System.out.print("\nLevelOrder:=>");
		while(!queue.isEmpty()) {
			TreeNode<T> loopNode = queue.poll(); 
			System.out.print(" "+loopNode.getData());
			if(loopNode.getLeft()!=null) {
				queue.add(loopNode.getLeft());
			}
			if(loopNode.getRight()!=null) {
				queue.add(loopNode.getRight());
			}
		}
		
	}
}
