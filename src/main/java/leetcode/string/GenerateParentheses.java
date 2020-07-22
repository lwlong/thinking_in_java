package leetcode.string;

import java.util.*;

/**
 *  https://leetcode.com/problems/generate-parentheses/
 *  22. Generate Parentheses
 *  Medium
 *
 *  数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *  https://www.cnblogs.com/ariel-dreamland/p/9133613.html
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));// ()
        System.out.println(generateParenthesis(2));// ()(),(())
        System.out.println(generateParenthesis(3));// (()())    ((()))    ()(())    (())()    ()()()

//        String s = "()()";
//        System.out.println(s.length()); //4
//        System.out.println(s.substring(0,1)); (
//        System.out.println(s.substring(1,4)); )()
    }

    /**
     * Runtime: 27 ms, faster than 5.13% of Java online submissions for Generate Parentheses.
     * Memory Usage: 42.4 MB, less than 5.01% of Java online submissions for Generate Parentheses.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n<=0){
            return result;
        }
        if(n==1){
            result.add("()");
            return result;
        }

        Set<String> strSet = new HashSet<String>();
        List<String> strList = generateParenthesis(n-1);
        for(String s : strList){
            strSet.add("()"+s);
            for(int i=1; i<s.length(); i++){
                strSet.add( s.substring(0,i)+"()"+s.substring(i,s.length()) );

            }
            strSet.add(s+"()");
        }

        for(String s:strSet){
            result.add(s);
        }
        return result;
//        return new ArrayList<String>(strSet);

    }
}



