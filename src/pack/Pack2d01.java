package pack;

//01背包，物品的重量w和容量c不能超过背包的限制
public class Pack2d01 {
    public static void main(String[] args){
        int[] c = {1,2,3,4};
        int[] w = {2,4,4,5};
        int[] v = {3,4,5,6};
        System.out.println(Pack2d01.find(c, w, v, 5, 6));
    }

    public static int find(int[] c, int[] w, int[] v, int capacity, int weight){
        int N = c.length;
        int[][] f = new int[capacity + 1][weight + 1];
        for (int i = 0; i < N; i++){
            for (int j = capacity; j >= c[i]; j--){
                for (int k = weight; k >= w[i]; k--){
                    f[j][k] = Math.max(f[j][k], f[j - c[i]][k - w[i]] + v[i]);
                }
            }
        }
        return f[capacity][weight];
    }
}
