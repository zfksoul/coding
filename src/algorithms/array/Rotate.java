package algorithms.array;

import java.util.Arrays;

/**
 * 将数组翻转
 * input:[5,6,1,2,3,4]
 * output:[1,2,3,4,5,6]
 */
public class Rotate {
    public static void main(String[] args){
        Rotate o = new Rotate();
        char[] c = {'5','6','1','2','3','4'};
        o.rotate2(c, 2);
        System.out.println(Arrays.toString(c));
    }

    public void rotate1(char[] c, int size){
        if (c == null || size <= 0 || size >= c.length){
            return;
        }
        reverse(c, 0, size - 1);
        reverse(c, size, c.length - 1);
        reverse(c, 0, c.length - 1);
    }

    private void reverse(char[] c, int l, int r) {
        char tmp = 0;
        while (l < r){
            tmp = c[l];
            c[l] = c[r];
            c[r] = tmp;
            l++;
            r--;
        }
    }
    public void rotate2(char[] c, int size){
        if (c == null || size <= 0 || size >= c.length){
            return;
        }
        int start = 0;
        int end = c.length - 1;
        int lpart = size;
        int rpart = c.length - size;
        int s = Math.min(lpart, rpart);
        int d = lpart - rpart;
        while (true){
            exchange(c, start, end, s);
            if (d == 0){
                break;
            } else if (d > 0){
                start += s;
                lpart = d;
            } else {
                end -= s;
                rpart = -d;
            }
            s = Math.min(lpart, rpart);
            d = lpart - rpart;
        }
    }

    private void exchange(char[] c, int start, int end, int size) {
        int i = end - size + 1;
        char tmp = 0;
        while (size-- != 0){
            tmp = c[start];
            c[start] = c[i];
            c[i] = tmp;
            start++;
            i++;
        }
    }
}
