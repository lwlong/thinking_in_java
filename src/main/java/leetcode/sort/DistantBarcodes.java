package leetcode.sort;

/**
 * https://leetcode.com/problems/distant-barcodes/
 * 1054. Distant Barcodes 距离相等的条形码
 * Medium
 *
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 */
public class DistantBarcodes {

    public static void main(String[] args) {
//        int[] barcodes= {1,1,1,2,2,2};
        int[] barcodes= {2,1,1};
//        int[] barcodes= {1,1,1,1,2,2,3,3};
        DistantBarcodes distantBarcodes = new DistantBarcodes();
        int[] result =  distantBarcodes.rearrangeBarcodes(barcodes);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] array = new int[barcodes.length];
        for(int i=0; i<barcodes.length; i++){
            array[i] = barcodes[i];
        }

        boolean flag = false;
        int times = 0;
        for(int i=1;i<array.length;i++) {
            if(array[i] == array[i-1]){
                for (int j = i+1; j < array.length; j++) {
                    //交换位置
                    if(array[j] != array[i]){
                        int tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                        times++;
                        break;
                    }
                }
            }
        }
        for(int i=array.length-2;i>=0;i--) {
            if(array[i] == array[i+1]){
                for (int j = i-1; j >= 0; j--) {
                    //交换位置
                    if(array[j] != array[i]){
                        int tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                        times++;
                        break;
                    }
                }
            }
        }
        System.out.println("times: "+times);

        return array;
    }
}
