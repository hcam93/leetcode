package Medium.ThreeSum;
import java.util.*;


public class threeSumSolution {


    /**
     * if array is less than 3 return empty list.
     * @param arr array of integers
     * @return list of all combinations of three numbers that add to zero
     */


    public static List<List<Integer>> threeSum(int[] arr){
        if(arr.length < 3) return List.of(List.of());
        Arrays.sort(arr);
        List<List<Integer>> listOfTriples = new ArrayList<>();
        int p0 = 0, p1 = 1, p2 = arr.length-1;
        while(p0 < p2 -1){
            while(p1 < p2){
                int current = arr[p1] + arr[p2];
                if(current + arr[p0] == 0){
                    listOfTriples.add(List.of(arr[p0], arr[p1] ,arr[p2]));
                    p1 = nextUniqueIndex(arr, p1, true);
                    p2 = nextUniqueIndex(arr, p2, false);
                    if(p1 == -1 || p2 == -1) break;
                }
                if(current + arr[p0] < 0) p1++;
                else p2--;
            }
            p0 = nextUniqueIndex(arr, p0, true);
            if(p0 == -1) return listOfTriples;
            p1 = p0 + 1;
            p2 = arr.length - 1;

        }
        return listOfTriples;
    }

    public static int nextUniqueIndex(int[] arr, int index, boolean accending){
        int current = arr[index];
        if(accending){
            for(int i = index; i < arr.length; i++){
                if(arr[i] != current) return i;
            }
        }else{
            for(int i = index; i >= 0; i--){
                if(arr[i] != current) return i;
            }
        }
        return -1;
    }


public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-4,-2,0,1,1, -1}));
    System.out.println(threeSum(new int[] {0,0,0}));
    System.out.println(threeSum(new int[] {0, -1, 2, -3, 1}));
}
}