package it.tt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有n个人要过河，但是河边只有一艘船；

 船每次最多坐三个人，每个人单独坐船过河的时间为a[i]；

 两个人或者三个人一起坐船时，过河时间为他们所有人中的最长过河时间；

 为了安全起见，要求每次至少有两个人才能过河。

 问最短需要多少时间，才能把所有人送过河。

 输入格式
 第一行是整数T，表示测试样例个数。

 每个测试样例的第一行是一个正整数n，表示参加过河的人数。

 第二行是n个正整数a[i]，表示n个人单独过河的时间；

 输出格式
 每个测试样例，输出一个最少的过河时间。

 每个结果占一行。

 数据范围
 2≤n<100000,
 0<a[i]<100000
 输入样例：
 2
 2
 1 2
 4
 1 1 1 1

 输出样例：
 2
 3

 按过河时间从小到大排序：x,y,z,k,...,b,a
 一次运1人：a+y
 xya
 xy
 一次运2人：z+y+a+z,不管怎么运都是这个结果
 xyz
 xy
 xab
 xz
 一次运3人：z+y+k+y+a+k,这种方式时间最短
 xyz
 xy
 xyk
 xy
 abc
 zk

 f[i]表示把i,...,n都运过去的最短时间
 边界条件f[4]+a3
 */
public class CrossRiver {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0){
            int n = in.nextInt();
            int[] a = new int[n + 1];
            long[] f = new long[n + 2];
            for (int i = 1; i <= n; i++){
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            if (n <= 2){
                System.out.println(a[2]);
            } else {
                f[n + 1] = 0;
                for (int i = n; i >= 4; i--){
                    //此时算的是把i人运过去，还要加上把i+1,...,n运过去的时间f[i+1]
                    f[i] = a[i] + a[2] + f[i + 1];
                    //当i <= n-1时，存在一次运2人的情况，此时时间为a[i+1]
                    //此时算的是把i,i+1人运过去，还要加上把i+2,...,n运过去的时间f[i+2]
                    if (i + 1 <= n) f[i] = Math.min(f[i], a[3] + a[2] + a[i + 1] + a[3] + f[i + 2]);
                    //当i <= n-2时，存在一次运3人的情况，此时时间为a[i+2]
                    //此时算的是把i,i+1,i+2人运过去，还要加上把i+3,...,n运过去的时间f[i+3]
                    if (i + 2 <= n) f[i] = Math.min(f[i], a[3] + a[2] + a[4] + a[2] + a[i + 2] + a[4] + f[i + 3]);
                }
                System.out.println(a[3] + f[4]);//边界条件
            }

        }
    }
}
