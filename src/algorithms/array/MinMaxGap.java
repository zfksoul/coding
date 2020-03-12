package algorithms.array;

import java.util.*;

/**
 * 有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 */
public class MinMaxGap {
    public static void main(String[] args){
        MinMaxGap o = new MinMaxGap();
        Scanner in = new Scanner(System.in);
        int n;
        int[] arr;
        int[] res = new int[2];
        while (in.hasNext()){
            n = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            o.fun(arr, res);
            System.out.println(res[0] + " " + res[1]);
            o.fun1(arr, res);
            System.out.println(res[0] + " " + res[1]);
        }
    }
    private void fun1(int[] arr, int[] res) {
        if (arr == null || arr.length < 2){
            res[0] = 0;
            res[1] = 0;
            return;
        }
        mySort(arr, 0, arr.length - 1);
        //如果数组中值都相等，直接返回结果
        if (arr[0] == arr[arr.length - 1]){
            int tmp = (arr.length * (arr.length - 1)) >> 1;
            res[0] = tmp;
            res[1] = tmp;
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        //求差最小个数
        int minres = 0;
        if (map.size() == arr.length){
            int min = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++){
                int tmp = arr[i] - arr[i - 1];
                if (min == tmp){
                    minres++;
                } else if (min > tmp){
                    minres = 1;
                    min = tmp;
                }
            }
        } else {
            for (Integer key : map.keySet()){
                int val = map.get(key);
                if (val > 1){
                    minres += (val * (val - 1)) >> 1;
                }
            }
        }
        res[0] = minres;
        //求差最大个数
        List<Integer> keySet = new ArrayList<>(map.keySet());
        int minCnt = map.get(keySet.get(0));
        int maxCnt = map.get(keySet.get(keySet.size() - 1));
        res[1] = minCnt * maxCnt;;
    }
    private void fun(int[] arr, int[] res) {
        if (arr == null || arr.length == 0){
            res[0] = 0;
            res[1] = 0;
            return;
        }
        mySort(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
        boolean repeat = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else {
                repeat = true;
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int minGap = Integer.MAX_VALUE;
        int maxGap = Integer.MIN_VALUE;

        int minCnt = 0;
        int cnt = 0;
        if (repeat){
            for (Map.Entry<Integer, Integer> e : map.entrySet()){
                cnt += (e.getValue() * (e.getValue() - 1)) >> 1;
            }
            res[0] = cnt;
        } else {
            for (int i = 0; i < arr.length - 1; i++){
                if (minGap > arr[i + 1] - arr[i]){
                    minGap = arr[i + 1] - arr[i];
                    minCnt = 1;
                } else if (minGap == arr[i + 1] - arr[i]){
                    minCnt++;
                }
            }
            res[0] = minCnt;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        minCnt = 0;
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
                minCnt = 1;
            } else if (min == arr[i]){
                minCnt++;
            }
            if (max < arr[i]){
                max = arr[i];
                maxCnt = 1;
            } else if (max == arr[i]){
                maxCnt++;
            }
        }
        res[1] = maxCnt * minCnt;
    }

    private void mySort(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int pivot = partition(arr, l, r);
        mySort(arr, l, pivot - 1);
        mySort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int ran = l + (int)(Math.random() * (r - l + 1));
        swap(arr, l, ran);
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] <= arr[l]){
                swap(arr, p++, i);
            }
        }
        swap(arr, p - 1, l);
        return p - 1;
    }
    public void swap(int[] arr, int l, int r){
        if (l == r){
            return;
        }
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
