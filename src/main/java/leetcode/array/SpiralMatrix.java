package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/spiral-matrix/
 *  54. Spiral Matrix
 *  Easy
 *
 *  Input:
 *  [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 *  ]
 *  Output: [1,2,3,6,9,8,7,4,5]
 *
 *  代码面试指南 P361 转圈打印矩阵 矩阵分圈处理
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 39.1 MB, less than 5.05% of Java online submissions for Spiral Matrix.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0){
            return result;
        }
        int topRow = 0;//左上角行号
        int topColumn = 0;//左上角列号
        int botRow = matrix.length-1;//右下角行号
        int botColumn = matrix[0].length-1;//右下角列号
        while(topRow<=botRow && topColumn<=botColumn){
            writeEdge(matrix, topRow,topColumn,botRow,botColumn,result);
            topRow++;
            topColumn++;
            botRow--;
            botColumn--;
        }
        return result;
    }

    public void writeEdge(int[][] matirx, int tR, int tC, int bR, int bC, List<Integer> result){
        if(tR == bR){ //子矩阵只有一行
            for(int i=tC; i<=bC; i++){
                result.add(matirx[tR][i]);
            }
        } else if(tC == bC) { //子矩阵只有一列
            for(int i=tR; i<=bR; i++){
                result.add(matirx[i][tC]);
            }
        } else{ //一般情况
            int curR = tR;
            int curC = tC;
            while(curC != bC){
                result.add(matirx[tR][curC]);
                curC++;
            }
            while(curR != bR){
                result.add(matirx[curR][bC]);
                curR++;
            }
            while(curC != tC){
                result.add(matirx[bR][curC]);
                curC--;
            }
            while(curR != tR){
                result.add(matirx[curR][tC]);
                curR--;
            }
        }
    }



}
