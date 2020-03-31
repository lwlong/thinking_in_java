package leetcode;

/**
 * Created by LWL on 2019/6/13.
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
