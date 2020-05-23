package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 9. Palindrome Number
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 123;
        boolean result = isPalindrome(x);
        System.out.println(x+" : "+result);
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
//        String s = String.valueOf(x);
//        int length = s.length();
//        for(int i=0; i< length/2; i++){
//            if(s.charAt(i) != s.charAt(length-1-i)){
//                return false;
//            }
//        }

        List<Integer> list = new ArrayList<Integer>();
        int n = 10;
        while(x != 0){
            list.add(x%n);
            x = x/n;
        }
        int size = list.size();
        for(int i=0; i< size/2; i++){
            if(list.get(i) != list.get(size-1-i)){
                return false;
            }
        }
        return true;
    }
}
