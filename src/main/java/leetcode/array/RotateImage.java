package leetcode.array;

/**
 * https://leetcode.com/problems/rotate-image/
 * 48. Rotate Image
 * Medium
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 *
 * //先按正对角线转换
 * //再按照中垂线转换
 * 技巧题
 */
public class RotateImage {
    public static void main(String[] args) {

//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("------");
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }


    public void rotate(int[][] matrix) {
        //先按正对角线转换
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }

        //再按照中垂线转换
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
                int x = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = x;
            }
        }

    }
}
