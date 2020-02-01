package algorithms.dp;

/**
 * 汉诺塔问题
 */
public class Hano {
    public static void main(String[] args){
        Hano o = new Hano();
        int[] arr = {1,2,3,3,3};
        System.out.println(o.step1(arr));
    }

    /**
     * f(i) = f(i-1)+1+f(i-1)
     * f(i)+1 = 2(f(i-1)+1)
     * f(1)+1 = 2
     * f(i)+1 = 2^i
     * f(i) = 2^i-1
     */
    public void hanoi(int n){
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

    public int step(int[] arr){
        if (arr == null || arr.length == 0){
            //throw new RuntimeException("invalid arr");
            return -1;
        }
        //return mycount(arr, arr.length - 1, 1, 2, 3);
        return process(arr, arr.length - 1, 1, 2, 3);

    }
    public int step2(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int from = 1;
        int mid = 2;
        int to = 3;
        int i = arr.length - 1;
        int res = 0;
        int tmp = 0;
        while (i >= 0){
            if (arr[i] != from && arr[i] != to){
                return -1;
            }
            if (arr[i] == to){
                res += 1 << i;
                tmp = from;
                from = mid;
            } else {
                tmp = to;
                to = mid;
            }
            mid = tmp;
            i--;
        }
        return res;
    }
    public int step1(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int res = 0;
        int left = 1;
        int mid = 2;
        int right = 3;
        int tmp;
        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] != left && arr[i] != right){
                return -1;
            }
            if (arr[i] == left){
                tmp = right;
                right = mid;
                mid = tmp;
                continue;

            } else {
                res += 1 << i;
                tmp = mid;
                mid = left;
                left = tmp;
            }
        }
        return res;
    }
    public int process(int[] arr, int i, int from, int mid, int to){
        if (i == -1){
            return 0;
        }
        if (arr[i] != from && arr[i] != to){
            return -1;
        }
        if (arr[i] == from){
            return process(arr, i - 1, from, to, mid);
        } else {
            int rest = process(arr, i - 1, mid, from, to);
            if (rest == -1){
                return -1;
            }
            return (1 << i) + rest;
        }
    }

    public int mycount(int[] arr, int n, int left, int mid, int right) {
        if (n == -1){
            return 0;
        } else if (arr[n] == left){
            return mycount(arr, n - 1, left, right, mid);
        } else if (arr[n] == right){
            return (1 << n) + mycount(arr, n - 1, mid, left, right);
        }
        throw new RuntimeException("invalid arr");
    }

}
