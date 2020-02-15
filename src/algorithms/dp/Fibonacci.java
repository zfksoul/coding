package algorithms.dp;

/**
 * 输出斐波那契数列中第n个数
 */
public class Fibonacci {
    public static void main(String[] args){
        Fibonacci o = new Fibonacci();
        System.out.println(o.Fibonacci(3));
    }
    public int Fibonacci(int n) {
        if (n < 1){
            return 0;
        } else if (n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
