package Medium.GenerateParentheses;
import java.util.*;

public class generateParaenthesesSolution {
    //Given n pairs of parentheses, write a function to generate all 
    //combinations of well-formed parentheses.
    // n = 2 == "()()", "(())"
    //n = 3 == "((()))","(()())","(())()","()(())","()()()"
    //This solution uses BFS, but I think you may use memoization for a faster solution. 

    public List<String> perfectParen(int n){
        if(n == 0) return List.of();
        if(n == 1) return List.of("()");
        List<String> list = new ArrayList<>();
        Queue<parenObj> queue = new LinkedList<>();
        queue.add(new parenObj("(", 1, 0));
        while(!queue.isEmpty()){
            parenObj currString = queue.poll();
            if(currString.curr.length() == n*2){
                list.add(currString.curr);
                continue;
            }
            if(currString.close == n || currString.open == currString.close){
                queue.add(new parenObj(currString.curr + "(", currString.open + 1, currString.close));
            }else if(currString.open == n){
                queue.add(new parenObj(currString.curr + ")", n, currString.close + 1));
            }else{
                queue.add(new parenObj(currString.curr + ")", currString.open, currString.close + 1));
                queue.add(new parenObj(currString.curr + "(", currString.open + 1, currString.close));
            }
        }
        return list;
    }

    class parenObj{
        int open;
        int close;
        String curr;
        public parenObj(String curr, int open, int close){
            this.close = close;
            this.open = open;
            this.curr = curr;
        }
    }

    public static void main(String[] args) {
        generateParaenthesesSolution temp = new generateParaenthesesSolution();
        System.out.println(temp.perfectParen(6));
    }
}
