package Easy.TwoSum;
import java.util.*;
public class twoSumSolution {
    
    /**
     * Given an array and a target, find the two integers that add to that
     * sum, return true if they exist, false otherwise
     */

     public static boolean solution(int[] array, int target){
         if(array.length < 2) return false;
        Arrays.sort(array);
        int pointerOne = 0;
        int pointerTwo = array.length - 1;
        while(pointerOne < pointerTwo){
            int current = array[pointerOne] + array[pointerTwo];
            if(current == target) return true;
            if(current < target) pointerOne++;
            else pointerTwo--; 
        }
        return false;
     }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,6,1,0,100,-80, 5}, -75) == true);
        System.out.println(solution(new int[] {3,6,1,0,100,-80, 5}, -80) == true);
        System.out.println(solution(new int[] {3,6,1,0,100,-80, 5}, 20) == true);
        System.out.println(solution(new int[] {0,0}, -80) == false);
        System.out.println(solution(new int[] {0}, 0) == false);
    }
}

