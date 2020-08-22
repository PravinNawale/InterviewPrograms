package DataStructure.stack;

/*
 * Own Stack Implementation
 */
public class StackImplementation {

	public static void main(String[] args) throws Exception {
		Stack<String> myStack = new Stack<String>();
		System.out.println("isEmpty =>" + myStack.isEmpty());
		System.out.println("isFull =>" + myStack.isFull());
		System.out.println("Size => " + myStack.size());
		myStack.push("Pravin");
		myStack.push("Manmohan");
		myStack.push("Sagar");
		System.out.println("Stack =>" + myStack);
		System.out.println("Size => " + myStack.size());
		System.out.println("Stack Pop =>" + myStack.pop());
		System.out.println("Stack Pop =>" + myStack.pop());
		System.out.println("Stack =>" + myStack);
		System.out.println("Size => " + myStack.size());
	}
}

class Stack<T> {
	private int intialCapacity = 10;
	private int length = -1;
	private Object[] stackArray;

	public Stack() {
		stackArray = new Object[intialCapacity];
	}

	public Stack(int customSize) {
		intialCapacity = customSize;
		stackArray = new Object[customSize];
	}

	public void push(T item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack Overflow!");
		} else {
			length++;
			stackArray[length] = item;
		}
	}

	public boolean isFull() {
		return (length == (intialCapacity - 1));
	}

	public T pop() throws Exception {
		T obj;
		if (isEmpty()) {
			throw new Exception("Stack Underflow!");
		} else {
			obj = (T) stackArray[length];
			length--;
		}
		return obj;
	}

	public boolean isEmpty() {
		return (length < 0);
	}

	public int size() {
		return (length + 1);
	}

	@Override
	public String toString() {
		String completeString = "[ ";
		for (int i=0;i<=length;i++) {
			completeString = completeString + " " + stackArray[i];
		}
		return completeString + " ]";
	}
}