package DataStructure.linkedlist;

class LinkedNode<T> {

	private Object data;
	private LinkedNode<T> next;

	public LinkedNode(T data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LinkedNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
}