package leetcode.math;

/**
 * https://leetcode.com/problems/island-perimeter/
 * 463. Island Perimeter 岛屿周长
 *
 */
public class IslandPerimeter {

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{0,1}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int perimeter = islandPerimeter.islandPerimeter(grid);
        System.out.println(perimeter);
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int width = grid.length;
        int length = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    if(i==0 || grid[i-1][j]!=1){perimeter++;}//up
                    if(i==width-1 || grid[i+1][j]!=1){perimeter++;}//down
                    if(j==0 || grid[i][j-1]!=1){perimeter++;}//left
                    if(j==length-1 || grid[i][j+1]!=1){perimeter++;}//right
                }
            }
        }

        return perimeter;
    }
}
