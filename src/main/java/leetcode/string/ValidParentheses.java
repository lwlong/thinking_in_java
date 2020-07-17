package leetcode.string;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/valid-parentheses/
 *  20. Valid Parentheses
 *  Easy
 *
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  栈
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));//true
        System.out.println(isValid("(]"));//false
        System.out.println(isValid("([)]"));//false
        System.out.println(isValid("]][["));//false
        System.out.println(isValid("()"));//true
    }

    /**
     * Runtime: 3 ms, faster than 26.26% of Java online submissions for Valid Parentheses.
     * Memory Usage: 39.2 MB, less than 14.03% of Java online submissions for Valid Parentheses.
     */
    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        char[] ss = s.toCharArray();
//        int statusSmall = 0; // () status 左括号+1 右括号-1 需要最后保持是0
//        int statusMiddle = 0; // []
//        int statusBig = 0; // {}

        Stack<Character> stack = new Stack<Character>();
//        System.out.println(ss.length);
        for(int i=0; i<s.length(); i++){
            if(ss[i]=='(' || ss[i]=='[' || ss[i]=='{' ){
                stack.push(ss[i]);
            }
            if(ss[i]==')' ){
                if(!stack.empty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ss[i]);
                }
            }else if(ss[i]==']'){
                if(!stack.empty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(ss[i]);
                }
            }else if(ss[i]=='}'){
                if(!stack.empty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(ss[i]);
                }
            }

        }
        return stack.empty();
//        return false;
    }
}
