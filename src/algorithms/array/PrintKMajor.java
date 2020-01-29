package algorithms.array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 给定一个数组，给定整数k，打印数组中出现次数大于N/K的数
 * 时间复杂度O(n*k)
 * 空间复杂度O(k)
 */
public class PrintKMajor {
    public static void main(String[] args){
        PrintKMajor o = new PrintKMajor();
        int[] arr = {1,1,1,3,4,5,5};
        o.myPrintKMajor(arr,3);
    }
    public void myPrintKMajor(int[] arr, int k){
        if (k < 2){
            System.out.print("the value of k is invalid");
            return;
        }
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (cands.containsKey(arr[i])){
                cands.put(arr[i], cands.get(arr[i]) + 1);
            } else {
                if (cands.size() == k - 1){
                    allCandsMinusOne(cands);
                } else {
                    cands.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        boolean hasPrint = false;
        for (Map.Entry<Integer, Integer> set : cands.entrySet()){
            Integer key = set.getKey();
            if (reals.get(key) > arr.length / k){
                hasPrint = true;
                System.out.print(key + " ");
            }
        }
        System.out.print(hasPrint ? "" : "no such number");
    }

    private HashMap<Integer,Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int curNum = arr[i];
            if (cands.containsKey(curNum)){
                if (reals.containsKey(curNum)){
                    reals.put(curNum, reals.get(curNum) + 1);
                } else {
                    reals.put(curNum, 1);
                }
            }
        }
        return reals;
    }

    private void allCandsMinusOne(HashMap<Integer, Integer> cands) {
        List<Integer> removeList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> set : cands.entrySet()){
            Integer key = set.getKey();
            Integer value = set.getValue();
            if (value == 1){
                removeList.add(key);
            }
            cands.put(key, value - 1);
        }
        for (Integer removeKey : removeList){
            cands.remove(removeKey);
        }
    }

    public void myPrintKMajor1(int[] arr, int k){
        int[] cand = new int[k-1];
        int[] times = new int[k-1];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < k-1; j++){
                if (times[j] == 0){
                    cand[j] = arr[i];
                    times[j]++;
                    break;
                } else if (cand[j] == arr[i]) {
                    times[j]++;
                    break;
                }
                if (j == k - 2){
                    for (int n = 0; n < k-1; n++){
                        times[n]--;
                    }
                }
            }
        }
        for (int i = 0; i < k - 1; i++){
            times[i]=0;
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < k - 1; j++){
                if (cand[j] == arr[i]){
                    times[j]++;
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < k - 1; i++) {
            if (times[i] > arr.length / k) {
                System.out.print(cand[i] + " ");
                flag = true;
            }
        }
        if (!flag){
            System.out.print("no such numbers");
        }
    }
}
