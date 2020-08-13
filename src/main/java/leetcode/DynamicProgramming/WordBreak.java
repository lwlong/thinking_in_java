package leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/word-break/
 * 139. Word Break 单词拆分
 * Medium
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 *
 * 其实应该是动态规划问题
 */
public class WordBreak {

    public static void main(String[] args) {
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                ["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "aaaaaaaa";
//        List<String> wordDict = new ArrayList<String>(Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"));
        List<String> wordDict = new ArrayList<String>(Arrays.asList("aaaa","aa","a"));
//        List<String> wordDict = new ArrayList<String>(Arrays.asList("aa","ba"));
//        String s = "aa";
//        List<String> wordDict = new ArrayList<String>(Arrays.asList("a","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));


        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean result = false;
        List<String> wordDictTmp = new ArrayList<String>();
        for(String str : wordDict){
            wordDictTmp.add(str);
        }
        for(String str : wordDict){
            wordDictTmp.remove(str);
//            System.out.println(str);
//            System.out.println(wordDictTmp);
            boolean resultSub = wordBreakSub(str, wordDictTmp);
//            System.out.println(resultSub);
            if(resultSub == false){
                wordDictTmp.add(str);
            }
        }
        System.out.println(wordDictTmp);

        result = wordBreakSub(s, wordDictTmp);

        return result;
    }

    public boolean wordBreakSub(String s, List<String> wordDict) {
        boolean result = false;
        Stack stack=new Stack();
        boolean finishFlag = false;
        stack.push(s);
        while(!stack.isEmpty()){
            String tmp = (String)stack.pop();

            for(String str : wordDict){
                if(tmp.equals(str)){
                    System.out.println(0.0);
                    finishFlag = true;
                }  else if(tmp.equals(str+str+str+str+str)){
                    System.out.println(0.5);
                    finishFlag = true;
                }  else if(tmp.equals(str+str+str)){
                    System.out.println(0.3);
                    finishFlag = true;
                } else if(tmp.startsWith(str+str+str+str+str)){
                    System.out.println(5);
                    stack.push(tmp.substring(str.length()*5));
                } else if(tmp.startsWith(str+str+str)){
                    System.out.println(3);
                    stack.push(tmp.substring(str.length()*3));
                } else if(tmp.startsWith(str)){
                    System.out.println(1);
                    stack.push(tmp.substring(str.length()));
                }
            }
        }
        if(stack.isEmpty() && finishFlag == true){
            result = true;
        }

        return result;
    }
}
