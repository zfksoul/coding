package algorithms.dp;

/**
 * input: express="1^0|0|1", desired=false
 * output:2
 * 1^((0|0)|1),1^(0|(0|1))
 */
public class ExpressDesired {
    public static void main(String[] args){
        ExpressDesired o = new ExpressDesired();
        String express = "1^0|0|1^0&1|0|1";
        boolean desired = false;
        System.out.println(o.num(express, desired));
        System.out.println(o.num1(express, desired));
        System.out.println(o.num2(express, desired));
        System.out.println(o.num3(express, desired));
    }
    public int num3(String express, boolean desired){
        if (express == null || express.equals("")){
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid1(exp)){
            return 0;
        }
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;
        for (int i = 2; i < exp.length; i += 2){
            t[i][i] = exp[i] == '0' ? 0 : 1;
            f[i][i] = exp[i] == '1' ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2){
                for (int k = j; k < i; k += 2){
                    if (exp[k + 1] == '&'){
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|'){
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else if (exp[k + 1] == '^'){
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length - 1] : f[0][f.length - 1];
    }
    /**
     * 时间复杂度O(n^3)
     * 空间复杂度O(n^2)
     */
    public int num2(String express, boolean desired){
        if (express == null || express.equals("")){
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid1(exp)){
            return 0;
        }
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        for (int i = 0; i < exp.length; i += 2){
            t[i][i] = exp[i] == '1' ? 1 : 0;
            f[i][i] = exp[i] == '0' ? 1 : 0;
        }
        for (int j = 2; j < exp.length; j += 2){
            for (int i = j - 2; i >= 0; i -= 2){
                for (int k = i + 1; k < j; k += 2){//有k找到p(i,j)的所有依赖
                    switch (exp[k]){
                        case '&':
                            t[i][j] += t[i][k - 1] * t[k + 1][j];
                            f[i][j] += t[i][k - 1] * f[k + 1][j];
                            f[i][j] += f[i][k - 1] * t[k + 1][j];
                            f[i][j] += f[i][k - 1] * f[k + 1][j];
                            break;
                        case '|':
                            t[i][j] += t[i][k - 1] * t[k + 1][j];
                            t[i][j] += t[i][k - 1] * f[k + 1][j];
                            t[i][j] += f[i][k - 1] * t[k + 1][j];
                            f[i][j] += f[i][k - 1] * f[k + 1][j];
                            break;
                        case '^':
                            t[i][j] += f[i][k - 1] * t[k + 1][j];
                            t[i][j] += t[i][k - 1] * f[k + 1][j];
                            f[i][j] += t[i][k - 1] * t[k + 1][j];
                            f[i][j] += f[i][k - 1] * f[k + 1][j];
                            break;
                    }
                }
            }
        }
        return desired ? t[0][exp.length - 1] : f[0][exp.length - 1];
    }

    /**
     * p(0,n-1)=p(0,0)+p(1,n-1))
     *         +p(0,1)+p(2,n-1))
     *         +..
     *         +p(0,i)+p(i+1,n-1)
     *         +..
     *         +p(0,n-2)+p(n-1,n-1)
     * 共n种
     * 可以拆成n个长度为n-1的表达式
     * 时间复杂度O(n!)
     */
    public int num1(String express, boolean desired){
        if (express == null || express.equals("")){
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid1(exp)){
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    private int p(char[] exp, boolean desired, int l, int r) {
        if (l == r){
            if (exp[l] == '1'){
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired){
            for (int i = l + 1; i < r; i += 2){
                switch (exp[i]){
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2){
                switch (exp[i]){
                    case '&':
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public int num(String express, boolean desired) {
        if (!isValid(express)){
            return 0;
        }
        return func(express, 0, express.length() - 1, desired);
    }

    private int func(String express, int l, int r, boolean desired) {
        if (l == r){
            if (desired){
                return express.charAt(l) == '1' ? 1 : 0;
            } else {
                return express.charAt(l) == '0' ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = l + 1; i < r; i += 2){
            if (desired){
                if (express.charAt(i) == '&'){
                    res += func(express, l, i - 1, desired) * func(express, i + 1, r, desired);
                } else if (express.charAt(i) == '|'){
                    res += func(express, l, i - 1, desired) * func(express, i + 1, r, !desired)
                         + func(express, l, i - 1, !desired) * func(express, i + 1, r, desired)
                         + func(express, l, i - 1, desired) * func(express, i + 1, r, desired);
                } else {
                    res += func(express, l, i - 1, desired) * func(express, i + 1, r, !desired)
                         + func(express, l, i - 1, !desired) * func(express, i + 1, r, desired);
                }
            } else {
                if (express.charAt(i) == '&'){
                    res += func(express, l, i - 1, desired) * func(express, i + 1, r, desired)
                         + func(express, l, i - 1, !desired) * func(express, i + 1, r, desired)
                         + func(express, l, i - 1, desired) * func(express, i + 1, r, !desired);
                } else if (express.charAt(i) == '|'){
                    res += func(express, l, i - 1, desired) * func(express, i + 1, r, desired);
                } else {
                    res += func(express, l, i - 1, !desired) * func(express, i + 1, r, !desired)
                         + func(express, l, i - 1, desired) * func(express, i + 1, r, desired);
                }
            }
        }
        return res;
    }
    public boolean isValid1(char[] express){
        if ((express.length & 1) == 0){
            return false;
        }
        for (int i = 0; i < express.length; i += 2){
            if (express[i] != '1' && express[i] != '0'){
                return false;
            }
        }
        for (int i = 1; i < express.length; i += 2){
            if (express[i] != '&' && express[i] != '|' && express[i] != '^'){
                return false;
            }
        }
        return true;
    }
    public boolean isValid(String express){
        if ((express.length() & 1) == 0){
            return false;
        }
        for (int i = 0; i <express.length(); i++){
            if ((i & 1) == 0){
                if(express.charAt(i) != '0' && express.charAt(i) != '1') {
                    return false;
                }
            } else {
                if (express.charAt(i) != '&' && express.charAt(i) != '|' && express.charAt(i) != '^'){
                    return false;
                }
            }
        }
        return true;
    }

}
