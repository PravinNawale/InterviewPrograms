package DataStructure.stack;

import java.util.Stack;

public class PrintStackAscendingOrder {

	public static void main(String[] args) {
		Stack<Integer> mainStack = new Stack<Integer>();
		mainStack.push(23);
		mainStack.push(3);
		mainStack.push(235);
		mainStack.push(253);
		mainStack.push(28);
		mainStack.push(2);
		mainStack.push(0);
		mainStack.push(344);
		mainStack.push(1);

		System.out.println("Main Stack:" + mainStack);
		//Collections.sort(mainStack);
		System.out.println("Main Stack in Ascending Order:=>" + sortStackAscending(mainStack));
	}

	private static Stack<Integer> sortStackAscending(Stack<Integer> mainStack) {
		Stack<Integer> sortedStack = new Stack<Integer>();
		while (!mainStack.isEmpty()) {
			int mainPopedValue = mainStack.pop();
			if (sortedStack.isEmpty()) {
				sortedStack.push(mainPopedValue);
			} else {
				while(!sortedStack.isEmpty() && sortedStack.peek()>mainPopedValue) {
					mainStack.push(sortedStack.pop());
				}
				sortedStack.push(mainPopedValue);
			}
		}
		return sortedStack;
	}
}
