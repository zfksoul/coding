package algorithms.dp;

/**
 * 汉诺塔问题
 */
public class Hano {
    public static void main(String[] args){
        Hano o = new Hano();
        int[] arr = {1,2,3,3,3};
        System.out.println(o.step1(arr));
        System.out.println(o.step(arr));
        System.out.println(o.step2(arr));
    }

    /**
     * f(i) = f(i-1)+1+f(i-1)
     * f(i)+1 = 2(f(i-1)+1)
     * f(1)+1 = 2
     * f(i)+1 = 2^i
     * f(i) = 2^i-1
     */
    public void hano1(int n){
        if (n <= 0){
            throw new RuntimeException("invalid n");
        }
        process1(n, "left", "mid", "right");
    }

    private void process1(int n, String from, String mid, String to) {
        if (n == 1){
            System.out.println("move from "+ from +" to " + to);
        } else {
            process1(n - 1, from, to, mid);
            //System.out.println("move from "+ from +" to " + to);
            process1(1, from, mid, to);
            process1(n - 1, mid, from, to);
        }
    }
    //给数组代表当前状态，求是第几步
    public int step(int[] arr){
        if (arr == null || arr.length == 0){
            //throw new RuntimeException("invalid arr");
            return -1;
        }
        //return mycount(arr, arr.length - 1, 1, 2, 3);
        return process(arr, arr.length - 1, 1, 2, 3);
    }
    public int process(int[] arr, int i, int from, int mid, int to){
        if (i == -1) return 0;
        if (arr[i] == from){
            return process(arr, i - 1, from, to, mid);
        } else if (arr[i] == to){
            int res = process(arr, i - 1, mid, from, to);
            if (res == -1){
                return -1;
            }
            return (1 << i) + res;
        } else {
            return -1;
        }
    }
    /*public int mycount(int[] arr, int n, int from, int mid, int to) {
        if (n == -1){
            return 0;
        } else if (arr[n] == from){
            return mycount(arr, n - 1, from, to, mid);
        } else if (arr[n] == to){
            return (1 << n) + mycount(arr, n - 1, mid, from, to);
        }
        throw new RuntimeException("invalid arr");
    }*/
    //非递归
    public int step1(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int res = 0;
        int from = 1;
        int mid = 2;
        int to = 3;
        int tmp;
        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] != from && arr[i] != to){
                return -1;
            }
            if (arr[i] == from){
                tmp = to;
                to = mid;
            } else {
                res += 1 << i;
                tmp = from;
                from = mid;
            }
            mid = tmp;
        }
        return res;
    }

    public int step2(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        int tmp = 0;
        int res = 0;
        int from = 1;
        int mid = 2;
        int to = 3;
        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] != from && arr[i] != to) return -1;
            if (arr[i] == from){
                tmp = to;
                to = mid;
            } else {
                res += 1 << i;
                tmp = from;
                from = mid;
            }
            mid = tmp;
        }
        return res;
    }



}
