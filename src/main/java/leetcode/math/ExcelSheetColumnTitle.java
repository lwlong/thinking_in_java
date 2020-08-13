package leetcode.math;

/**
 *  https://leetcode.com/problems/excel-sheet-column-title/
 *  168. Excel Sheet Column Title
 *  Easy
 *
 *  //代码面试指南 P491 伪26进制数
 *
 *  https://leetcode-cn.com/problems/excel-sheet-column-title/solution/jin-zhi-zhuan-huan-0ms-by-liveinhw/
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
//        int n = 26;// Z
//        String s = convertToTitle(n);
//        System.out.println(s);

        System.out.println(convertToTitle(26)); //Z
        System.out.println(convertToTitle(2)); //B
        System.out.println(convertToTitle(27)); //AA
        System.out.println(convertToTitle(52)); //AZ
        System.out.println(convertToTitle(54)); //BB
        System.out.println(convertToTitle(702)); //AA
        System.out.println(convertToTitle(703)); //AAA
    }

    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while(n>0){
            n --;//这里稍作处理，因为它是从1开始
            stringBuilder.append((char)(n % 26 + 'A'));
            n = n/26;
        }
        return stringBuilder.reverse().toString();//注意倒转过来
    }

}
