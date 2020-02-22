package dfs;

import java.util.Arrays;
//每行，每列，每个九宫格的数字都在1-9不重复
public class Sudoku {
    public static void main(String[] args){
        char[][] board = {{'5','3','.', '.','7','.', '.','.','.'},
                          {'6','.','.', '1','9','5', '.','.','.'},
                          {'.','9','8', '.','.','.', '.','6','.'},

                          {'8','.','.', '.','6','.', '.','.','3'},
                          {'4','.','.', '8','.','3', '.','.','1'},
                          {'7','.','.', '.','2','.', '.','.','6'},

                          {'.','6','.', '.','.','.', '2','8','.'},
                          {'.','.','.', '4','1','9', '.','.','5'},
                          {'.','.','.', '.','8','.', '.','7','9'}};

        Sudoku o = new Sudoku();
        o.solveSudoku(board);
        for (int i = 0; i < board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public void solveSudoku1(char[][] board){
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return;
        }
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] cell = new boolean[3][3][9];
        int k = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    k = board[i][j] - '1';
                    row[i][k] = col[j][k] = cell[i / 3][j / 3][k] = true;
                }
            }
        }
        dfs2(board, 0, 0, row, col, cell);
    }

    private boolean dfs2(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][][] cell) {
        if (y == 9){
            x++;
            y = 0;
        }
        if (x == 9){
            return true;
        }
        if (board[x][y] != '.') {
            return dfs2(board, x, y + 1, row, col, cell);
        }
        for (int i = 0; i < 9; i++){
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]){
                board[x][y] = (char) (i + '1');
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs2(board, x, y + 1, row, col, cell)){
                    return true;
                }
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }


    //标记已经添过的数字
    public void solveSudoku(char[][] board){
        boolean[][] row = new boolean[9][9];//每行的每个数字是否被填过
        boolean[][] col = new boolean[9][9];//每列的每个数字是否被填过
        boolean[][][] cell = new boolean[3][3][9];//每个九宫格的每个数字是否被填过
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if (c != '.'){
                    int t = c - '1';
                    row[i][t] = col[j][t] = cell[i/3][j/3][t] = true;
                }
            }
        }
        dfs(board,0,0, row, col, cell);//从左到右，从上到下搜索

    }

    private boolean dfs(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][][] cell) {
        if (y == 9){//搜索下一行
            x++;
            y = 0;
        }
        if (x == 9){
            return true;
        }
        if (board[x][y] != '.') return dfs(board,x,y+1, row, col, cell);//这个位置有数字，直接搜索下一个位置
        //这个位置没数字，在该位置尝试9个数字，如果都不对，则本分支搜索不到
        for (int i = 0; i < 9; i++){
            if (!row[x][i] && !col[y][i] && !cell[x/3][y/3][i]){
                board[x][y] = (char) ('1'+i);
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = true;
                if (dfs(board,x,y+1, row, col, cell)) return true;
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }


}
