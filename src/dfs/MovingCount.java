package dfs;

public class MovingCount {
    public static void main(String[] args){
        MovingCount o = new MovingCount();
        System.out.println(o.myMovingCount(15, 20, 20));
    }
    public int myMovingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[][] record = new boolean[rows][cols];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        return move(threshold, rows, cols, 0, 0, record, dx, dy);
    }

    public int move(int threshold, int rows, int cols, int i, int j, boolean[][] record, int[] dx, int[] dy) {
        record[i][j] = true;
        int res = 1;
        for (int k = 0; k < 4; k++){
            int a = i + dx[k];
            int b = j + dy[k];
            if (a >= 0 && a < rows && b >= 0 && b < cols && !record[a][b] && getCount(a) + getCount(b) <= threshold){
                res += move(threshold, rows, cols, a, b, record, dx, dy);
            }
        }
        return res;
    }

    public int getCount(int n){
        int cnt = 0;
        while (n > 0){
            cnt += n % 10;
            n /= 10;
        }
        return cnt;
    }
}
