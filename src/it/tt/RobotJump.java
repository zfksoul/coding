package it.tt;

import java.util.Scanner;

/**
 * 机器人正在玩一个古老的基于DOS的游戏。

 游戏中有N+1座建筑——从0到N编号，从左到右排列。

 编号为0的建筑高度为0个单位，编号为 i 的建筑高度为H(i)个单位。

 起初，机器人在编号为0的建筑处。

 每一步，它跳到下一个（右边）建筑。

 假设机器人在第k个建筑，且它现在的能量值是E，下一步它将跳到第k+1个建筑。

 如果H(k+1)>E，那么机器人就失去H(k+1)-E的能量值，否则它将得到E-H(k+1)的能量值。

 游戏目标是到达第N个建筑，在这个过程中能量值不能为负数个单位。

 现在的问题是机器人至少以多少能量值开始游戏，才可以保证成功完成游戏？

 输入格式
 第一行输入整数N。

 第二行是N个空格分隔的整数，H(1),H(2),…,H(N)代表建筑物的高度。

 输出格式
 输出一个整数，表示所需的最少单位的初始能量值上取整后的结果。

 数据范围
 1≤N,H(i)≤10^5,

 输入样例1：
 5
 3 4 3 2 4
 输出样例1：
 4
 输入样例2：
 3
 4 4 4
 输出样例2：
 4
 输入样例3：
 3
 1 6 4
 输出样例3：
 3
 */
public class RobotJump {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] h = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            h[i] = in.nextInt();
            max = Math.max(max, h[i]);
        }
        int E = 0;
        int l = 0;
        int r = max;
        while (l < r){
            E = (l + r) >> 1;
            if (f(E, h)){
                r = E;
            } else {
                l = E + 1;
            }
        }
        System.out.println(l);

    }
    public static boolean f(long E, int[] h){
        for (int i = 0; i < h.length; i++){
            E = 2 * E - h[i];
            if (E < 0) return false;
            if (E > 1000010) return true;//h(i)最大值为10^5，E大于此则一定成立
        }
        return true;
    }
}
