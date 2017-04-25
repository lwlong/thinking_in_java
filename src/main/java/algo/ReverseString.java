package algo;

/**
 * Created by Lwlong on 2017/3/7.
 */
public class ReverseString {
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static String reverse2(String originStr) {

        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String args[]){
        String a = "abcde";
        System.out.println(a.substring(1));//bcde
        String b = reverse(a);
        System.out.println(b);
    }
}
