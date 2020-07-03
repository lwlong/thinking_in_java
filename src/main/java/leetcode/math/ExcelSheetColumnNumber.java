package leetcode.math;

/**
 *  https://leetcode.com/problems/excel-sheet-column-number/
 *  171. Excel Sheet Column Number
 *  //代码面试指南 P491 伪26进制数
 *  https://blog.csdn.net/u013554860/article/details/80922673
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "AAA";
        int result = titleToNumber(s);
        System.out.println(result);
    }

    public static int titleToNumber(String s) {
        if(s==null){
            return 0;
        }
        char[] strc = s.toCharArray();
        int res = 0;
        for(int i=0; i<strc.length; i++){
            res = res * 26;
            res += strc[i] - 'A' + 1;
        }
        return res;
    }
}
