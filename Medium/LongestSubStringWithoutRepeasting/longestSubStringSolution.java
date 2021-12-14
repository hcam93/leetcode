package Medium.LongestSubStringWithoutRepeasting;
import java.util.*;
public class longestSubStringSolution {
    

    //Given a string s, find the length of the longest substring without repeating characters.
    // This is a sliding window problem. 
    // Run time O(n)
    // space complexity O(n)

    public static int solution(String s){
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int pointerOne = 0;
        int pointerTwo = 1;
        charMap.put(s.charAt(pointerOne), 1);
        while(pointerTwo < s.length()){
            char currentChar = s.charAt(pointerTwo);
            charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);
            while(charMap.get(currentChar) > 1){
                char pointerOneVal = s.charAt(pointerOne);
                charMap.put(pointerOneVal, charMap.getOrDefault(pointerOneVal, 0) -1);
                if(charMap.get(pointerOneVal) == 0) charMap.remove(pointerOneVal);
                pointerOne++;
            }
            pointerTwo++;
            max = Math.max(max, charMap.size());
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(solution("pwwkew") == 3);
        System.out.println(solution("abcabcbb") == 3);
        System.out.println(solution("bbbbb") == 1);
    }
}