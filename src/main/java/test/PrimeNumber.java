package test;

/**
 * Created by LWL on 2017/11/28.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int i, j;
        for (i = 2; i <= 100; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0)
                    break;
            }
            if (j >= i)
                System.out.print(i+" ");
        }

//        boolean bool;
//        for (int i = 3; i < 100; i+=2) {
//            bool = true;
//            for (int j = 3; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) {
//                    bool = false;
//                    break;
//                }
//            }
//            if (bool)
//                System.out.print(i + " ");
//        }

        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        System.out.println(b == c);     // true b自动拆箱成int类型再和c比较

    }
}

//3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
//3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97