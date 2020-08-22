package DataStructure.stack;

import java.util.Stack;

/*
    Design stack to for get the Max in it in O(1)
*/
public class DesignStackToFindMaxAtAnyPoint {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(1);
        customStack.push(23);
        customStack.push(4);
        customStack.push(2);
        customStack.push(567);
        System.out.println("Max of stack:=>" + customStack.getMax());
        customStack.pop();
        System.out.println("Max of stack:=>" + customStack.getMax());
        customStack.pop();
        customStack.pop();
        customStack.pop();
        System.out.println("Max of stack:=>" + customStack.getMax());
    }
}

class CustomStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> trackStack = new Stack<>();

    public void push(int number) {
        mainStack.push(number);
        if(trackStack.isEmpty()) {
            trackStack.push(number);
        } else {
            if(number > trackStack.peek()){
                trackStack.push(number);
            } else {
                trackStack.push(trackStack.peek());
            }
        }
    }

    public int pop() {
        int element = mainStack.pop();
        trackStack.pop();
        return element;
    }

    public int getMax() {
        if(!trackStack.isEmpty()) {
            return trackStack.peek();
        }
        return -1;
    }
}
