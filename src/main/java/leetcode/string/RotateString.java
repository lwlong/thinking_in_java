package leetcode.string;

/**
 *  https://leetcode.com/problems/rotate-string/
 *  https://leetcode-cn.com/problems/string-rotation-lcci/
 *  796. Rotate String
 *  Easy
 *
 *  代码面试指南 P254 判断两个字符串是否互为旋转词
 *  abcde -> cdeab true
 */
public class RotateString {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab")); //true
        System.out.println(rotateString("abcde","abced")); //false
        System.out.println(rotateString("waterbottle","erbottlewat"));//true
        System.out.println(rotateString("aa","aba"));//false
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
     * Memory Usage: 38.9 MB, less than 13.84% of Java online submissions for Rotate String.
     */
    public static boolean rotateString(String A, String B) {
        if(A==null || B==null || A.length()!=B.length()){
            return false;
        }
        String B2 = B+B;
        return B2.indexOf(A)!=-1;

    }
}
