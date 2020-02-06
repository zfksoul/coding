package algorithms.others;

/**
 * 第一年平均年龄y
 * 离职率x
 * 新人年龄21
 * 总人数w
 * 第二年平均年龄：W*(1-x)*(y+1)+21xw/w=(1-x)*(y+1)+21x=(1-x)y+20x+1=ay+b
 * f(n)=af(n-1)+b
 * f(n)+b/(a-1)=a(f(n-1)+b/(a-1))
 * g(n)=(a^n)g(0)
 * g(0)=y+b/(a-1)
 * 以O(logn)时间复杂度求a^n
 */
public class AverageAge {
    public static void main(String[] args){
        AverageAge o = new AverageAge();
        int x = 0;
        int y = 0;
        int n = 0;
        o.getNYearsAge(y, x, n);
    }

    public int getNYearsAge(int y, int x, int n) {
        double a = 1 - x;
        double b = 1 + 20 * x;
        double base = y + b / (a - 1);
        //double res = Math.pow(a, n) * base;
        double res = getPower(a, n) * base;
        return (int) Math.ceil(res - b / (a - 1));
    }
    public double getPower(double a, int n){
        double res = 1;
        for (; n != 0; n >>= 1){
            if ((n & 1) != 0){
                res *= a;
            }
            a *= a;
        }
        return res;
    }
}
