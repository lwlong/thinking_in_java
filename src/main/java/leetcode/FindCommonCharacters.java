package leetcode;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWL on 2019/4/18.
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] A = new String[3];
//        A[0] = "bella";
//        A[1] = "label";
//        A[2] = "rolla";

        A[0] = "cool";
        A[1] = "lock";
        A[2] = "cook";

        FindCommonCharacters fcc = new FindCommonCharacters();
        List<String> result = fcc.commonChars(A);
        System.out.println(result);



    }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        List<String> strList = new ArrayList<String>();
        int minLength = 200;
        String minStr = "";
        for(int i=0; i<A.length; i++){
            A[i].length();

            char[] tmp = A[i].toCharArray();
            Arrays.sort(tmp);
            strList.add(String.valueOf(tmp));
            if(A[i].length()<minLength){
                minLength = A[i].length();
                minStr = String.valueOf(tmp);
            }
        }
//        for(String s:strList){
//            System.out.println(s);
//        }

        int[] charIndex = new int[minLength];

        for(char c: minStr.toCharArray()){

            boolean isExisteAll = true;
            for(int i=0; i<A.length; i++){
                int indexTmp = strList.get(i).substring(charIndex[i]).indexOf(c);
                if(indexTmp==-1){
                    isExisteAll = false;
                    break;
                }else{
                    charIndex[i] = charIndex[i] + indexTmp+1;
                }
            }
            if(isExisteAll==true){
                result.add(String.valueOf(c));
            }


        }


        return result;
    }



}
