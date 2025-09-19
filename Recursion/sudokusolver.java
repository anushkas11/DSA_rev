import java.util.*;

public class sudokusolver {
    public static List<String> solveSudoku(char[][] board) {
        solve(board);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) return true;
                            board[i][j] = '.'; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private static boolean isValid(char[][] board, int r, int c, char num) {
        for (int j = 0; j < 9; j++) {
            if (board[r][j] == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) return false;
        }
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        List<String> solved = solveSudoku(board);
        for (String row : solved) {
            System.out.println(row);
        }
    }
}
