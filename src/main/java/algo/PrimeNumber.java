package algo;

import java.util.ArrayList;

/**
 * Created by Lwlong on 2017/2/20.
 */
public class PrimeNumber {
    public static void main(String[] args) {
//        int j;
//        for (int i = 2; i <= 100; i++) // 1不是素数，所以直接从2开始循环
//        {
//            j = 2;
//            while (i % j != 0) {
//                j++; // 测试2至i的数字是否能被i整除，如不能就自加
//            }
//            if (j == i) // 当有被整除的数字时，判断它是不是自身
//            {
//                System.out.print(i+" "); // 如果是就打印出数字
//            }
//        }
        //2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
        ArrayList<Integer> list = new ArrayList();
        list.add(2);
        for (int i = 2; i <= 100; i++) // 1不是素数，所以直接从2开始循环
        {
            boolean flag = true;
            for(int j=0;j<list.size();j++){
                if(i% (int)list.get(j)==0){
                    flag =false;
                    break;
                }
            }
            if(flag==true){
                list.add(i);
                System.out.print(i+" ");
            }
        }
    }
}
