package it.tt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 多源最短路问题
 * 1.所有起点加入队列
 * 2.队列bfs
 *
 * 来源： 今日头条2019，笔试题
 * 公司的程序员不够用了，决定把产品经理都转变为程序员以解决开发时间长的问题。
 在给定的矩形网格中，每个单元格可以有以下三个值之一：
 值0代表空单元格;
 值1代表产品经理;
 值2代表程序员;
 每分钟，任何与程序员(在4个正方向上)相邻的产品经理都会变成程序员。
 返回直到单元格中没有产品经理为止所必须经过的最小分钟数。
 如果不可能，返回-1。
 以下是一个4分钟转变完成的示例：
 2 1 1      2 2 1      2 2 2      2 2 2      2 2 2
 1 1 0  ->  2 1 0  ->  2 2 0  ->  2 2 0  ->  2 2 0
 0 1 1      0 1 1      0 1 1      0 2 1      0 2 2
 输入格式
 不固定多行（行数不超过10），毎行是按照空格分割的数字(不固定，毎行数字个数不超过10)。
 其中每个数组项的取值仅为0、1、2三种。
 读取时可以按行读取，直到读取到空行为止，再对读取的所有行做转换处理。
 输出格式
 如果能够将所有产品经理变成程序员，则输出最小的分钟数。
 如果不能够将所有的产品经理变成程序员，则返回-1.
 输入样例1：
 0 2
 1 0
 输出样例1：
 -1
 输入样例2：
 1 2 1
 1 1 0
 0 1 1
 输出样例2：
 3
 输入样例3：
 1 2
 2 1
 1 2
 0 1
 0 1
 1 1
（空行）
 //while (in.hasNext()){}当控制台没有输入时会阻塞等待输入，不能用来判断输入结束
 //直到读取到空行为止while (!"".equals(s = in.nextLine())){}
 输出样例3：
 4

 空间复杂度O(m*n)
 */
public class bfs {

    /*public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = 0;
        int n = 0;
        int[][] g = new int[10][10];
        int[][] dist = new int[10][10];
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String s;
        while (!"".equals(s = in.nextLine())){//nextLine()的结束符是回车键，所以最后一行测试数据要加回车，
                                              //本地调试时可以以空行""判断结束
                                              //上机调试时会以流末尾判断结束，不能以""判断结束
        //while((s=in.readLine())!=null){//当BufferReader读到流的末尾时，返回null，读文件流结束时返回null
            String[] strs = s.trim().split(" ");
            n = strs.length;
            for (int i = 0; i < strs.length; i++){
                g[m][i] = Integer.parseInt(strs[i]);
            }
            m++;
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (g[i][j] == 2){
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = dist[x][y];
            for (int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == 1 && dist[a][b] == -1){
                    dist[a][b] = d + 1;
                    q.offer(new Pair(a, b));
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (g[i][j] == 1){
                    if (dist[i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, dist[i][j]);
                }
            }
        }
        System.out.println(res);

    }*/
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int m = 0;
        int n = 0;
        List<int[]> g = new ArrayList<>();
        List<int[]> dist = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String s;
       // while (in.hasNext()){//上机调试时用hasNext()判断输入流结束
        while (!"".equals(s = in.nextLine())) {//本地调试时用空行判断输入流结束
            s = in.nextLine();
            String[] strs = s.trim().split(" ");
            n = strs.length;
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = Integer.parseInt(strs[i]);
            }
            g.add(tmp);
            dist.add(new int[n]);
        }
        m = g.size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist.get(i)[j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g.get(i)[j] == 2) {
                    dist.get(i)[j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = dist.get(x)[y];
            for (int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < m && b >= 0 && b < n && g.get(a)[b] == 1 && dist.get(a)[b] == -1){
                    dist.get(a)[b] = d + 1;
                    q.offer(new Pair(a, b));
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (g.get(i)[j] == 1){
                    if (dist.get(i)[j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, dist.get(i)[j]);
                }
            }
        }
        System.out.println(res);

    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

