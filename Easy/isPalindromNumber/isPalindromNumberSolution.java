package Easy.isPalindromNumber;

public class isPalindromNumberSolution {
    

    /**
     * simple two pointer problems 
     * @param x
     * @return boolean of number if palindrome
     */
    public static boolean isPalindrome(int x){
        if(x < 0) return false;
        if(x / 10 == 0) return true;
        String stringVal = String.valueOf(x);
        int pointerOne = 0;
        int pointerTwo = stringVal.length() - 1;
        while(pointerOne < pointerTwo){
            if(stringVal.charAt(pointerOne) == stringVal.charAt(pointerTwo)){
                pointerOne++;
                pointerTwo--;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
