package Easy.closestSocket;

public class closestSocketSolution {
    

    /**
     * Given a target and an array, either moving left or right in the array, determine the shortest distance
     * to the target, if target doesnt exist return 0;
     * @param tools
     * @param target
     * @return shortest distance, 0 if target doesnt exist.
     */

     /**
      * This is a two pointer problem that uses index tricks using mod factor with math. 
      */

    public static int findClosest(String[] tools, String target, int index){
        if(tools.length < 2) return 0;
        if(index < 0 || index >= tools.length) return 0;
        int pointerOne = index;
        int pointerTwo = index;
        int counter = 0;
        while(counter < tools.length){
            String leftVal = tools[pointerOne];
            String rightVal = tools[pointerTwo];
            if(leftVal.equals(target) || rightVal.equals(target)) return counter;
            pointerOne--;
            pointerTwo = (pointerTwo + 1) % tools.length;
            if(pointerOne < 0) {
                pointerOne = (tools.length + pointerOne) % tools.length; 
            }else{
                pointerOne %= tools.length;
            }
            counter++;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(findClosest(new String[]{"A", "B", "D", "F", "C", "C"}, "C", 1) == 2);
        System.out.println(findClosest(new String[]{"A", "B", "D", "F", "R", "K"}, "C", 1) == 0);
        System.out.println(findClosest(new String[]{"A", "B", "D", "C", "C"}, "C", 1) == 2);
        System.out.println(findClosest(new String[]{"A"}, "A", 0) == 0);
        System.out.println(findClosest(new String[]{"A", "B", "D", "F", "C", "C", "K", "L", "R", "T", "Y"}, "Y", 4) == 5);
        System.out.println((1 + 5) % 5);
    }
}
