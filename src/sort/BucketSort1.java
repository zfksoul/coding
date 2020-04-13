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
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            } else if (arr[i] > max){
                max = arr[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = ((max - min) / bucketSize) + 1;
        for (int i = 0; i < bucketCount; i++){
            buckets.add(new LinkedList<Integer>());
        }
        for (Integer data : arr){
            insertSort(buckets.get((data - min) / bucketSize),data);
        }
        int k = 0;
        for (LinkedList<Integer> bucket : buckets){
            for (Integer data : bucket){
                arr[k++] = data;
            }
        }
    }

    private void insertSort(LinkedList<Integer> bucket, int data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean flag = true;
        while (it.hasNext()){
            if (it.next() > data){
                it.previous();
                it.add(data);
                flag = false;
                break;
            }
        }
        if (flag) it.add(data);
    }

    private void myBucketSort1(float[] arr) {
        ArrayList<LinkedList<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            buckets.add(new LinkedList<Float>());
        }
        for (float data : arr){
            insertSort1(buckets.get((int)data),data);
        }
        int k = 0;
        for (LinkedList<Float> bucket : buckets){
            for (float data : bucket){
                arr[k++] = data;
            }
        }
    }

    private void insertSort1(LinkedList<Float> bucket, float data) {
        ListIterator<Float> it = bucket.listIterator();
        boolean flag = true;
        while (it.hasNext()){
            if (it.next() > data){
                it.previous();
                it.add(data);
                flag = false;
                break;
            }
        }
        if (flag) it.add(data);
    }
}
