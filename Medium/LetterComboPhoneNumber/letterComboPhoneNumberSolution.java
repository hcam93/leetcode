package Medium.LetterComboPhoneNumber;
import java.util.*;

public class letterComboPhoneNumberSolution {
    

    /**
        Given a string containing digits from 2-9 inclusive, 
        return all possible letter combinations that the number could represent. 
        Return the answer in any order.
        A mapping of digit to letters (just like on the telephone buttons) is given below.
        Note that 1 does not map to any letters.
    */

    //This is a BFS or DFS solution, the run time is always exponential. 

    public static List<String> letterCombo(String digits){
        if(digits.equals(null) || digits.isEmpty()) return List.of();
        HashMap<Integer, List<String>> numberToChar = new HashMap<>(7);
        numberToChar.put(2, List.of("a", "b", "c"));
        numberToChar.put(3, List.of("d", "e", "f"));
        numberToChar.put(4, List.of("g", "h", "i"));
        numberToChar.put(5, List.of("j", "k", "l"));
        numberToChar.put(6, List.of("m", "n", "o"));
        numberToChar.put(7, List.of("p", "q", "r", "s"));
        numberToChar.put(8, List.of("t", "u", "v"));
        numberToChar.put(9, List.of("w", "x", "y", "z"));
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i < digits.length(); i++){
            String currentDig = String.valueOf(digits.charAt(i));
            List<String> allNums = numberToChar.get(Integer.valueOf(currentDig));
            if(queue.isEmpty()){
                queue.addAll(allNums);
            }else{
                Queue<String> tempQueue = new LinkedList<>();
                while(!queue.isEmpty()){
                    String currentString = queue.poll();
                    for(int j =0; j < allNums.size(); j++){
                        tempQueue.add(currentString + allNums.get(j));
                    }
                }
                queue = tempQueue;
            }
        }
        List<String> list = new ArrayList<>(queue);
        return list;

        
    }

    public static void main(String[] args) {
        System.out.println(letterCombo("23").equals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf")));
    }
}
