package unionfind;

public class UnionFind {
    private int[] father;
    public UnionFind(int num){
        father = new int[num];
        for (int i = 0; i < num; i++){
            father[i] = i;
        }
    }
    public int findUnRecur(int n){
        while (father[n] != n){
            n = father[n];
        }
        return n;
    }
    public int findRecur(int n){
        if (father[n] == n){
            return n;
        }
        father[n] = findRecur(father[n]);//路径压缩
        return father[n];
    }
    public boolean union(int a, int b){//返回a和b是否本身在一个集合中
        int fa = findUnRecur(a);
        int fb = findUnRecur(b);
        father[fb] = fa;
        return fa == fb;
    }
}
