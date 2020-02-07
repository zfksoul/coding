package algorithms.array;

public class TrianglePath {
    public static void main(String[] args){
        TrianglePath o = new TrianglePath();
        int[][] t = {{2},{3,4},{6,5,7},{4,1,6,3}};
        System.out.println(o.minPath(t));
    }

    private int minPath(int[][] t) {
        if (t == null || t.length == 0 || t[0] == null || t[0].length == 0){
            return 0;
        }
        for (int i = t.length - 2; i >= 0; i--){
            for (int j = 0; j < t[i].length; j++){
                t[i][j] += Math.min(t[i + 1][j], t[i + 1][j + 1]);
            }
        }
        return t[0][0];
    }
}
