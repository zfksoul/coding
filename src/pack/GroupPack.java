package pack;

import java.util.Scanner;

/**
 * 分组背包
 * 有多组物品，每组只能选0或1个
 */
/* input:
  3 5
  2
  1 2
  2 4
  1
  3 4
  1
  4 5
 output:
  8*/
public class GroupPack {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();//有N组
        int capacity = in.nextInt();
        int[] f = new int[capacity + 1];
        for (int i = 0; i < N; i++){
            int n = in.nextInt();//第i组有n个
            int[] c = new int[n];
            int[] v = new int[n];
            for (int s = 0; s < n; s++){
                c[s] = in.nextInt();
                v[s] = in.nextInt();
            }
            for (int j = capacity; j >= 0; j--){//循环体积
               for (int k = 0; k < n && j >= c[k]; k++) {//循环策略
                   f[j] = Math.max(f[j], f[j - c[k]] + v[k]);
               }
            }
        }
        System.out.println(f[capacity]);
    }

}
