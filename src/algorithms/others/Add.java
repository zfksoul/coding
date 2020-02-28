package algorithms.others;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 没有进位的加法：s1 ^ s2
 * 进位：(s1&s2)<<1
 * 不断循环相加，直到进位为0
 */
public class Add {
    public static void main(String[] args){
        Add o = new Add();
        System.out.println(o.myAdd(4,5));
    }
    public int myAdd(int num1,int num2) {
        int res1 = 0;
        int res2 = 0;
        do{
            res1 = num1 ^ num2;
            res2 = (num1 & num2) << 1;
            num1 = res1;
            num2 = res2;
        }while (res2 != 0);
        return res1;
    }
}
