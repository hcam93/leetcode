package Easy.longestCommonPrefix;

public class longestPrefixSolution {
    

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".
     */

     public static String commonPrefix(String[] arr){
        if(arr.length == 0) return "";
        if(arr.length == 1) return arr[0];
        String longestPre = arr[0];
        for(int i = 1; i < arr.length; i++){
            String currentWord = arr[i];
            for(int j =0; j <  longestPre.length(); j++){
                if(j >= currentWord.length() || currentWord.charAt(j) != longestPre.charAt(j)){
                    longestPre = longestPre.substring(0, j);
                }
            }
        }
        return longestPre;
     }


    public static void main(String[] args) {
        System.out.println(commonPrefix(new String[] {"flower","flow","flight"}).equals("fl"));
        System.out.println(commonPrefix(new String[] {"dog","racecar","car"}).equals(""));
        System.out.println(commonPrefix(new String[] {"dog"}).equals("dog"));
        System.out.println(commonPrefix(new String[] {"ab", "a"}).equals("a"));
    }
}
