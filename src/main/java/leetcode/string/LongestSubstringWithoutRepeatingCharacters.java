package leetcode.string;

/**
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *  3. Longest Substring Without Repeating Characters
 *  Medium
 *
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  代码面试指南 P300
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring1("abcabcbb"));//3  abc
//        System.out.println(lengthOfLongestSubstring1("bbbbb"));//1  b
//        System.out.println(lengthOfLongestSubstring1("pwwkew"));//3  wke

//        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3  abc
//        System.out.println(lengthOfLongestSubstring("bbbbb"));//1  b
//        System.out.println(lengthOfLongestSubstring("pwwkew"));//3  wke
//        System.out.println(lengthOfLongestSubstring("abcd"));//4
        System.out.println(lengthOfLongestSubstring("abcabcd"));//4

    }

    /**
     * Runtime: 4 ms, faster than 90.74% of Java online submissions
     * Memory Usage: 41.3 MB, less than 19.34% of Java online submissions
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        char[] ss = s.toCharArray();
        int[] map = new int[256]; //用来存储每个字符最后一次出现的位置
        for(int i=0; i<256; i++){
            map[i] = -1;
        }
        int len=0;
        int pre=-1;
        int cur=0;

        for(int i=0; i<s.length(); i++) {
            pre = Math.max(pre, map[ss[i]]); //这个字符上一次出现的位置
            cur = i - pre;   //中间的距离就是最长的长度
            len = Math.max(len,cur);
            System.out.println("ssi: "+ss[i]+" pre: "+pre+" & cur: "+cur+" & len: "+len);
            map[ss[i]]=i;
        }
        return len;
    }

    /**
     * Runtime: 23 ms, faster than 18.40% of Java online submissions
     * Memory Usage: 51.9 MB, less than 5.00% of Java online submissions
     */
    public static int lengthOfLongestSubstring1(String s) {
        int beginIndexResult = 0;
        int lengthResult = 0;
        int beginIndexTmp = 0;
        int lengthTmp = 0;

        for(int i=0; i<s.length(); i++){
            String sTmp = s.substring(beginIndexTmp, beginIndexTmp+lengthTmp);
            if(sTmp.contains(s.substring(i,i+1))){
                beginIndexTmp = s.lastIndexOf(s.substring(i,i+1),i-1)+1;
                lengthTmp = i-s.lastIndexOf(s.substring(i,i+1),i-1);
            }else{
                lengthTmp++;
            }
            if(lengthTmp>lengthResult){
                beginIndexResult = beginIndexTmp;
                lengthResult = lengthTmp;
            }
        }
        return  lengthResult;
    }
}
