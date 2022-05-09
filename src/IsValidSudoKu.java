import java.util.HashMap;
import java.util.Map;

public class IsValidSudoKu {
    public boolean isValidSudoku(char[][] board) {
        return across(board)&&line(board)&&three(board);
    }

    public boolean across(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        for (char[] chars : board) {
            for (int i = 0; i < board.length; i++) {
                if(chars[i]=='.'){
                    continue;
                }
                if (map.containsKey(chars[i])) {
                    return false;
                }
                map.put(chars[i], 1);
            }
            map.clear();
        }
        return true;
    }

    public boolean line(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (char[] chars : board) {
                if(chars[i]=='.'){
                    continue;
                }
                if (map.containsKey(chars[i])) {
                    return false;
                }
                map.put(chars[i], 1);
            }
            map.clear();
        }
        return true;
    }

    public boolean three(char[][] board) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<board.length;) {
            for(int j = 0;j<board.length;) {
                for(int n = i;n<i+3;n++) {
                    for(int m = j;m<j+3;m++) {
                        if(board[n][m]=='.'){
                            continue;
                        }
                        if (map.containsKey(board[n][m])) {
                            return false;
                        }
                        map.put(board[n][m], 1);
                    }
                }
                map.clear();
                j +=3;
            }
            i+=3;
        }
        return true;
    }
}
