package DataStructure.array;

import java.util.Arrays;

/*
 * ArrayList Implementation
 */
public class OwnArrayList {
	public static void main(String[] args) {
		CustomArrayList<String> customArrayList = new CustomArrayList<String>(5);
		System.out.println("customArrayList =>" + customArrayList.isFull());
		System.out.println("customArrayList => " + customArrayList.size());
		customArrayList.add("1");
		customArrayList.add("2");
		customArrayList.add("3");
		customArrayList.add("4");
		customArrayList.add("5");
		customArrayList.add("6");
		System.out.println("customArrayList => " + customArrayList);
	}
}

class CustomArrayList<T> {

	private int intialCapacity = 10;
	private int length = -1;
	private Object[] myArrayList;

	public CustomArrayList() {
		myArrayList = new Object[intialCapacity];
	}

	public CustomArrayList(int customSize) {
		intialCapacity = customSize;
		myArrayList = new Object[customSize];
	}

	public void add(T item) {
		if (isFull()) {
			resizeArray();
		}
		length++;
		myArrayList[length] = item;
	}

	private void resizeArray() {
		myArrayList = Arrays.copyOf(myArrayList, intialCapacity * 2);
	}

	public boolean isFull() {
		return (length == (intialCapacity - 1));
	}

	public T get(int index) throws Exception {
		T obj = (T) myArrayList[index];
		return obj;
	}

	public int size() {
		return (length + 1);
	}

	@Override
	public String toString() {
		String completeString = "[ ";
		for (int i = 0; i <= length; i++) {
			completeString = completeString + " " + myArrayList[i];
		}
		return completeString + " ]";
	}
}
