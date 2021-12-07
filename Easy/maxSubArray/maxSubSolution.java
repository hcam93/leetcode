package Easy.maxSubArray;

public class maxSubSolution {
    
    /**
     * 
     * @return max contiguous sub-array
     */

    public static int maxSub(int[] arr){
        int max = (int)(Math.pow(10, 4) * -1.0),
         maxSoFar = (int)(Math.pow(10, 4) * -1.0);
        for(int i =0; i < arr.length; i++){
            maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
            max = Math.max(maxSoFar, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSub(new int[] {-1, 2, 3, 4, -100, 20}) == 20);
        System.out.println(maxSub(new int[] {-1, 2, 3, 4, -1, -1}) == 9);
        System.out.println(maxSub(new int[] {-1, 2, 3, 4, -1, 2}) == 10);
    }
}
