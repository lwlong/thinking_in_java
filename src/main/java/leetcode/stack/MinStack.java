package leetcode.stack;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/min-stack/
 *  155. Min Stack
 *  Easy
 *
 *  代码面试指南 P1 带getMin功能的栈
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());// return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        if(stackMin.empty()){
            stackMin.push(x);
        }else if(x<stackMin.peek()){
            stackMin.push(x);
        }else{
            stackMin.push(stackMin.peek());
        }
        stackData.push(x);
    }

    public void pop() {
        stackMin.pop();
        stackData.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }


}
