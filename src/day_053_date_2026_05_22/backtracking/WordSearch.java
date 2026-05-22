package day_053_date_2026_05_22.backtracking;

public class WordSearch {
    static int ROWS;
    static int COLS;
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
       ROWS = board.length;
       COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i==word.length()){
            return true;
        }
        if(r<0 || r>=ROWS || c<0 || c>=COLS || board[r][c]!=word.charAt(i) || board[r][c]=='#'){
            return false;
        }

        char ch = board[r][c];
        board[r][c] = '#';

        boolean result= dfs(board, word, r+1, c, i+1)
                || dfs(board, word, r, c+1, i+1)
                || dfs(board, word, r-1, c, i+1)
                || dfs(board, word, r, c-1, i+1);

        board[r][c] = ch;

        return result;
    }
}
