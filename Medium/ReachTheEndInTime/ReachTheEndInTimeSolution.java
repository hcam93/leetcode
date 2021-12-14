package Medium.ReachTheEndInTime;
import java.util.*;

public class ReachTheEndInTimeSolution {
    
    /**
     * A 2-D grid consisting of some blocked (represented as '#') and some unblocked
    (represented as .") cells is given. The starting position of a pointer is in the top-left
    corner of the grid. It is guaranteed that the starting position is in an unblocked cell. It
    is also guaranteed that the bottom-right cell is unblocked. Each cell of the grid is
    connected with its right, left, top, and bottom cells (if those cells exist). It takes 1
    second for a pointer to move from a cell to its adiacent cell. If the pointer can reach
    the bottom-right corner of the grid within k seconds, return the string 'Yes.
    Otherwise, return the string 'No'.
     * @param grid
     * @param time
     * @return A string of yes or no depending on if the time can be made or not. 
     */

    public String endInTime(List<String> grid, int time){
        if(grid.isEmpty()) return "No";
        char charArr[][] = new char[grid.size()][grid.get(0).length()];
        for(int i =0; i < grid.size(); i++){
            char[] tempCharArray = grid.get(i).toCharArray();
            for(int j = 0; j < tempCharArray.length; j++){
                charArr[i][j] = tempCharArray[j];
            }
        }
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(0, 0, 0));
        Set<List<Integer>> seen = new HashSet<>();
        seen.add(List.of(0,0));
        while(!queue.isEmpty()){
            Path location = queue.poll();
            if(location.column == charArr[0].length-1 && location.row == charArr.length -1){
                return location.currentTime <= time ? "Yes" : "No";
            } 
            if(validLoc(charArr, location.row + 1, location.column) && !seen.contains(List.of(location.row + 1, location.column))){
                queue.add(new Path(location.currentTime + 1, location.row + 1, location.column));
                seen.add(List.of(location.row + 1, location.column));
            }
            if(validLoc(charArr, location.row -1, location.column) && !seen.contains(List.of(location.row - 1, location.column))){
                queue.add(new Path(location.currentTime + 1, location.row - 1, location.column));
                seen.add(List.of(location.row - 1, location.column));
            }
            if(validLoc(charArr, location.row, location.column +1) && !seen.contains(List.of(location.row, location.column+1))){
                queue.add(new Path(location.currentTime + 1, location.row, location.column + 1));
                seen.add(List.of(location.row, location.column + 1));
            }
            if(validLoc(charArr, location.row, location.column -1) && !seen.contains(List.of(location.row, location.column-1))){
                queue.add(new Path(location.currentTime + 1, location.row, location.column - 1));
                seen.add(List.of(location.row, location.column - 1));
            }
        }
        return "No";
    }
    class Path {
        int currentTime;
        Integer row;
        Integer column;
        public Path(int currentTime, int row, int column){
            this.column = column;
            this.row = row;
            this.currentTime = currentTime;
        }
    }
    public static boolean validLoc(char[][] matrix, int row, int col){
        return  row >= 0 && col < matrix[0].length && col >= 0 && row < matrix.length && matrix[row][col] == '.';
    }
}

class solution {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(List.of("..#.", ".##.", "...."));
        List<String> l2 = new ArrayList<>(List.of("..#", "#.#", "#.."));
        List<String> l3 = new ArrayList<>(List.of("..#..#", "....##", "......"));
        ReachTheEndInTimeSolution temp1 = new ReachTheEndInTimeSolution();
        System.out.println( temp1.endInTime(l1, 4).equals("No"));
        System.out.println( temp1.endInTime(l2, 5).equals("Yes"));
        System.out.println(temp1.endInTime(l2, 4).equals("Yes"));
        System.out.println(temp1.endInTime(l2, 3).equals("No"));
        System.out.println(temp1.endInTime(l3, 6).equals("No"));
        System.out.println(temp1.endInTime(l3, 7).equals("Yes"));
    }
}
