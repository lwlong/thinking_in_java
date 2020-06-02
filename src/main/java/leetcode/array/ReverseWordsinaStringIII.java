package leetcode.array;

/**
 *  https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *  557. Reverse Words in a String III
 */
public class ReverseWordsinaStringIII {


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(s);
        String ss=reverseWords(s);
        System.out.println(ss.getClass().getName());
        System.out.println(ss);
    }

    public static String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            if(ss[i] == ' '){
                end = i-1;
                reverseString(ss, start, end);
                start = i+1;
            }
        }
        end = s.length()-1;
        reverseString(ss, start, end);
        return String.valueOf(ss);
    }

    public static void reverseString(char[] s, int start, int end) {
        if(end>start){
            while(start<=(end+start)/2){
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                end--;
                start++;
            }
        }

    }
}
