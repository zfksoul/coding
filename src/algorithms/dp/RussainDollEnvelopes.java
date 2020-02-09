package algorithms.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussainDollEnvelopes {
    public static void main(String[] args){
        RussainDollEnvelopes o = new RussainDollEnvelopes();
        int[][] es = {{1,2},
                      {3,7},
                      {4,3},
                      {5,6}};
        System.out.println(o.maxEnvelopes(es));
        System.out.println(o.maxEnvelopes1(es));
    }
    public int maxEnvelopes1(int[][] es){
        if (es == null || es.length == 0 || es[0] == null || es[0].length == 0){
            return 0;
        }
        Dot[] dots = new Dot[es.length];
        for (int i = 0; i < es.length; i++){
            dots[i] = new Dot(es[i][0], es[i][1]);
        }
        Arrays.sort(dots, new DotComparator());
        int[] help = new int[es.length];
        help[0] = dots[0].h;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < dots.length; i++){
            l = 0;
            r = right;
            while (l <= r){
                m = (l + r) / 2;
                if (dots[i].h > help[m]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            help[l] = dots[i].h;
        }
        return right + 1;
    }

    public int maxEnvelopes(int[][] es){
        if (es == null || es.length == 0 || es[0] == null || es[0].length == 0){
            return 0;
        }
        Dot[] dots = new Dot[es.length];
        for (int i = 0; i < es.length; i++){
            dots[i] = new Dot(es[i][0], es[i][1]);
        }
        Arrays.sort(dots, new DotComparator());
        int[] help = new int[es.length];
        int[] dp = new int[es.length];
        int l;
        int r;
        int right = 0;
        int res = 0;
        for (int i = 0; i < es.length; i++){
            l = 0;
            r = right;
            while (l < r){
                int mid = (l + r) / 2;
                if (help[mid] < dots[i].h){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            help[l] = dots[i].h;
            dp[i] = l + 1;
            right = Math.max(right, l + 1);
        }
        for (int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

class DotComparator implements Comparator<Dot> {
    @Override
    public int compare(Dot d1, Dot d2) {
        if (d1.w == d2.w){
            if (d1.h == d2.h){
                return 0;
            } else if (d1.h < d2.h){
                return 1;
            } else {
                return -1;
            }
        } else if (d1.w < d2.w){
            return -1;
        } else {
            return 1;
        }
    }
}
class Dot{
    int w;
    int h;
    public Dot(int weight, int hight){
        this.w = weight;
        this.h = hight;
    }
}