package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BucketSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 31, 42, 53, 2, 3, 53, 3, 2, 43, 2, 54, 65, 43, 23};
        //float[] arr = new float[]{0.12f, 2.2f, 8.8f, 7.6f, 7.2f, 6.3f, 9.0f, 1.6f, 5.6f, 2.4f};
        BucketSort1 o = new BucketSort1();
        o.myBucketSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void myBucketSort(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
            if (max < arr[i]){
                max = arr[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++){
            buckets.add(new LinkedList<>());
        }
        for (int i = 0; i < arr.length; i++){
            insertAdd(buckets.get((arr[i] - min) / bucketSize),arr[i]);
        }
        int k = 0;
        for (List<Integer> bucket : buckets){
            for (Integer i : bucket){
                arr[k++] = i;
            }
        }
    }

    private void insertAdd(LinkedList<Integer> bucket, int i) {
        ListIterator it = bucket.listIterator();
        boolean flag = false;
        while (it.hasNext()){
            if((int)it.next() > i){
                it.previous();
                it.add(i);
                flag = true;
                break;
            }
        }
        if (!flag){
            it.add(i);
        }
    }

}