package leetcode.string;

/**
 *  https://leetcode.com/problems/reverse-string/
 *  344. Reverse String
 *  Easy
 */
public class ReverseString {
    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o','o'};
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {

        int length = s.length;
        for(int i=0;i<length/2;i++){
            char tmp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = tmp;
        }

    }
}
