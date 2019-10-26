package binarysearch;

/**
* 
*
* @author zfk
* @date 2019年10月26日 上午11:00:16 
* 返回x的平方根，x非负整数，由于返回类型是整数，结果只保留整数部分，小数部分将被舍去
*/
public class Sqrt {

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.mySqrt(2147483647));
    }
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while(l < r) {
            int mid = (l + r + 1) >> 1;
            if (mid <= x / mid) {//防止mid平方溢出
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
