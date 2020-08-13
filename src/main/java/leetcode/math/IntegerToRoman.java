package leetcode.math;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * 12. Integer to Roman
 *
 * Input: 4
 * Output: "IV"
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public static void main(String[] args) {

        IntegerToRoman integerToRoman = new IntegerToRoman();
        String result = integerToRoman.intToRoman(58);
        System.out.println(result);
    }


    public String intToRoman(int num) {
        String result = "";
        String[] symbol= {"M","C","X","I"};
        String[] symbol2= {"","D","L","V"};

        int tmp = num;
        int times = 0;
        int baseNum = 1000;
        while(baseNum != 0){
            int count = tmp/baseNum;
            switch(count){
                case 1 : result += symbol[times]; break;
                case 2 : result += symbol[times]+symbol[times]; break;
                case 3 : result += symbol[times]+symbol[times]+symbol[times]; break;
                case 4 : result += symbol[times]+symbol2[times] ;break;
                case 5 : result += symbol2[times]; break;
                case 6 : result += symbol2[times]+symbol[times]; break;
                case 7 : result += symbol2[times]+symbol[times]+symbol[times]; break;
                case 8 : result += symbol2[times]+symbol[times]+symbol[times]+symbol[times]; break;
                case 9 : result += symbol[times]+symbol[times-1]; break;
                default :
            }
            tmp = tmp%baseNum;
            baseNum = baseNum/10;
            times++;
        }
        return result;
    }


}
