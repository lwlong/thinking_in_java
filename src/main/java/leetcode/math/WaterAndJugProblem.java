package leetcode.math;

/**
 *  https://leetcode.com/problems/water-and-jug-problem/
 *  365. Water and Jug Problem 水壶问题
 *  Medium
 *
 *  能否用下x，y获得z升水： 如果z是两个水壶容量的最大公约数的倍数，且 z <= x+y，那么必然可以
 *  Input: x = 2, y = 6, z = 5
 *  Output: False
 *  最大公约数 辗转相除法 代码面试指南 P448
 *  https://blog.csdn.net/qq_21201267/article/details/102980961
 */
public class WaterAndJugProblem {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int z = 12;
        boolean result = canMeasureWater(x,y,z);
        System.out.println(result);

    }


    public static boolean canMeasureWater(int x, int y, int z) {
        if(z > x+y){
            return false;
        }
        if(z==0){
            return true;
        }
        int gcd = getGreatestCommonDivisor(x,y);
        if(gcd==0){
            return false;
        }
        return z%gcd == 0;
    }

    public static int getGreatestCommonDivisor(int x, int y){
        return y==0 ? x : getGreatestCommonDivisor(y, x%y);
    }
}
