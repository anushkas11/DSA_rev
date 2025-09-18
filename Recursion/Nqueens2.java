import java.util.*;

public class Nqueens2 {
    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return nqueen(board, 0);
    }

    private static int nqueen(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                count += nqueen(board, row + 1);
                board[row][j] = '.';
            }
        }
        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // east and west
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') return false;
        }
        // north south
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // north-east
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        // south-east
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        // south west
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        // north west
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = totalNQueens(n);
        System.out.println(total);
        sc.close();
    }
}
