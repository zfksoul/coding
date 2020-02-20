package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在二维字符矩阵中判断单词是否存在
 * 枚举起点，从起点开始依次搜索下一个点的位置，在枚举过程中保证和目标单词匹配
 * 时间复杂度：共n*m和个点，如果路径长度为k，每个字母在搜索时有三个方向可选
 * O(nm*3^k)
 */
public class WordSearch {

    public static void main(String[] args){
        char[][] board = {{'a','b','c'},
                          {'d','e','f'},
                          {'g','h','i'}};
        WordSearch o = new WordSearch();
        System.out.println(o.exist(board,"bee"));
    }
    public boolean exist(char[][] board, String word){
        if (board == null || board[0] == null) return false;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs1(board,i,j,word,dx,dy,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, int x, int y, String word, int[] dx, int[] dy, int n) {
        if (board[x][y] != word.charAt(n)) return false;
        if (n == word.length() - 1) return true;
        board[x][y] = '.';
        for (int i = 0; i < dx.length; i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < dx.length && b >= 0 && b < dy.length){
                if (dfs1(board, a, b, word, dx, dy, n + 1)) return true;
            }
        }
        board[x][y] = word.charAt(n);
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word,int[] dx, int[] dy, int n) {
        if (board[x][y] != word.charAt(n)) return false;
        if (n == word.length() - 1) return true;
        board[x][y] = '.';          //用过该位置标记不能再用
        for (int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < board.length && b >= 0 && b < board[0].length){
                if (dfs(board, a, b, word, dx, dy, n+1)) return true;
            }
        }
        board[x][y] = word.charAt(n);//回溯，恢复初始状态
        return false;
    }
}
