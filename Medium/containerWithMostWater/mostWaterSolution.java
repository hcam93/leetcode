package Medium.containerWithMostWater;


public class mostWaterSolution{

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
     * Find two lines, which, together with the x-axis forms a container, such that the container contains
     *  the most water.
        Notice that you may not slant the container.
     */

     //This solution is a two pointer problem, requires comparing heights

     public static int maxArea(int[] heights){
        int maxVolume = Integer.MIN_VALUE;
        int pointerOne = 0;
        int pointerTwo = heights.length - 1;
        while(pointerOne < pointerTwo){
            maxVolume = Math.max(maxVolume, getVolume(pointerOne, pointerTwo, heights));
            if(heights[pointerOne] > heights[pointerTwo]){
                pointerTwo--;
            }else{
                pointerOne++;
            }
        }
        return maxVolume;
     }
     public static int getVolume(int leftMost, int rightMost, int[] heights){
         return Math.min(heights[leftMost], heights[rightMost]) * (rightMost - leftMost);
     }

    public static void main(String[] args) {
        System.out.println(maxArea(new int [] {1,1,6,2,5,4,8,3,7}));
    }
}