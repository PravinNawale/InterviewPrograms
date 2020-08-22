package DataStructure.tree;

public class TreeNode<T> {

	private TreeNode<T> left;
	private int data;
	private TreeNode<T> right;

	public TreeNode(TreeNode<T> left, int data, TreeNode<T> right) {
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}
