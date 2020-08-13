package leetcode.stack;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/implement-queue-using-stacks/
 *  232. Implement Queue using Stacks
 *  Easy
 *
 *  代码面试指南 P5 用栈实践队列
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        try {
            System.out.println(queue.peek());  // returns 1
            System.out.println(queue.pop());   // returns 1
            System.out.println(queue.empty()); // returns false
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class MyQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void pushToPop(){
            if(stackPop.isEmpty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackPush.push(x);
            pushToPop();
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() throws Exception {
            if(stackPush.empty() && stackPop.empty()){
                throw new Exception("empty queue");
            }
            pushToPop();
            return stackPop.pop();
        }

        /** Get the front element. */
        public int peek() throws Exception {
            if(stackPush.empty() && stackPop.empty()){
                throw new Exception("empty queue");
            }
            pushToPop();
            return stackPop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackPush.empty() && stackPop.empty();
        }
    }
}
