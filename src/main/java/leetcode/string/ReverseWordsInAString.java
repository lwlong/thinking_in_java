package leetcode.string;

/**
 *  https://leetcode.com/problems/reverse-words-in-a-string/
 *  151. Reverse Words in a String
 *  Medium
 *
 *  代码面试指南 P267 翻转字符串
 *  翻转两次即可，注意相同题型 ABCDE size=3->DEABC
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "I'm a  student ";
        System.out.println(s+"|");
        System.out.println(reverseWords(s)+"|");// student a I'm

        s = "a good   example";
        System.out.println(s+"|");
        System.out.println(reverseWords(s)+"|");// example good a

    }

    /**
     * Runtime: 3 ms, faster than 76.04% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 39.1 MB, less than 98.38% of Java online submissions for Reverse Words in a String.
     */
    public static String reverseWords(String s) {
        if(s == null){
            return null;
        }
        char[] ss = s.trim().toCharArray();
        StringBuilder result = new StringBuilder();
        reverse(ss, 0, ss.length-1,null);

        int start = 0;
        int end = 0;
        for(int i=0; i<ss.length; i++){
            if(ss[i]==' '){
                end = i-1;
                reverse(ss, start, end, result);
                start = i+1;
            }
        }
        end = ss.length-1;
        reverse(ss, start, end, result);
//        return String.valueOf(ss).trim();
        return result.toString().trim();
    }

    public static void reverse(char[] s, int start, int end, StringBuilder result) {
        char tmp = 0;
        int l=start;
        int r=end;
        if(end>=start){
            while(start<end){
                tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                end--;
                start++;
            }
            if(result!=null){
                for(int j=l; j<=r; j++){
                    result.append(s[j]);
                }
                result.append(" ");
            }

        }

    }
}
