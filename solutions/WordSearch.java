/**
 * 79. Word Search
 */

package solutions;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (findWord(board, used, row, col, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean findWord(char[][] board, boolean[][] used, int row, int col, char[] arr, int pointer) {
        if (pointer == arr.length) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != arr[pointer] || used[row][col]) return false;
        used[row][col] = true;

        if (findWord(board, used, row-1, col, arr, pointer + 1)
            || findWord(board, used, row + 1, col, arr, pointer + 1)
            || findWord(board, used, row, col-1, arr, pointer + 1)
            || findWord(board, used, row, col+1, arr, pointer + 1)
        ) {
            used[row][col] = false;
            return true;
        }

        used[row][col] = false;
        return false;
    }
}
