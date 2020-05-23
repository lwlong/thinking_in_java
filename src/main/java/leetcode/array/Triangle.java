package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lwlong on 2019/7/12.
 * https://leetcode.com/problems/triangle/
 * 120. Triangle
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangleList = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(2));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(3,4));
        List<Integer> c = new ArrayList<Integer>(Arrays.asList(6,5,7));
        List<Integer> d = new ArrayList<Integer>(Arrays.asList(4,1,8,3));
        triangleList.add(a);
        triangleList.add(b);
        triangleList.add(c);
        triangleList.add(d);
        Triangle triangle = new Triangle();
        int minimumTotal = triangle.minimumTotal(triangleList);
        System.out.println(minimumTotal);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.addAll(triangle.get(triangle.size()-1));
        for(int i=triangle.size()-2; i>=0; i--){
            List<Integer> triangleRow = triangle.get(i);
            for(int j=0; j<triangleRow.size(); j++){
                tmpList.set(j, triangleRow.get(j) + minInteger(tmpList.get(j),tmpList.get(j+1)));
            }
        }
        return tmpList.get(0);
    }

    public int minInteger(Integer a, Integer b){
        return a>b?b:a;
    }
}
