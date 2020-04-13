package sort;

import java.util.*;

/**
* 
*
* @author zfk
* @date 2019年10月30日 下午11:01:50 
* 
*/
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,31,42,53,2,3,53,3,2,43,2,54,65,43,23};
        //float[] arr = new float[]{0.12f, 2.2f, 8.8f, 7.6f, 7.2f, 6.3f, 9.0f, 1.6f, 5.6f, 2.4f};
        BucketSort o = new BucketSort();
        o.myBucketSort2(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public void myBucketSort(float[] arr) {
        ArrayList<LinkedList<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            buckets.add(new LinkedList<>());
        }
        for (float data : arr){
            int index = getBucketIndex(data);

            insertSort(buckets.get(index),data);
        }
        int k = 0;
        for (LinkedList<Float> bucket : buckets){
            for (Float data : bucket){
                arr[k++] = data;
            }
        }
    }
    public void myBucketSort1(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = ((max - min) / bucketSize) + 1;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++){
            buckets.add(new LinkedList<Integer>());
        }
        for (int data : arr){
            int index = (data - min) / bucketSize;
            insertSort1(buckets.get(index),data);
        }
        int k = 0;
       /* for(int i = 0; i < 10; i++){
            ListIterator<Integer> it = buckets.get(i).listIterator();
            while(it.hasNext()){
                arr[k++] = it.next();
            }
        }*/
        for (LinkedList<Integer> bucket : buckets){
            for (int  data : bucket){
                arr[k++] = data;
            }
        }
    }
    public void myBucketSort2(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = ((max - min) / bucketSize) + 1;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++){
            buckets.add(new LinkedList<Integer>());
        }
        for (int data : arr){
            int index = (data - min) / bucketSize;
            insertSort1(buckets.get(index),data);
        }
        int k = 0;
       /* for(int i = 0; i < 10; i++){
            ListIterator<Integer> it = buckets.get(i).listIterator();
            while(it.hasNext()){
                arr[k++] = it.next();
            }
        }*/
        for (LinkedList<Integer> bucket : buckets){
            for (int  data : bucket){
                arr[k++] = data;
            }
        }
    }

    private void insertSort1(LinkedList<Integer> bucket, int data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean flag = true;
        while(it.hasNext()){
            if (it.next() > data){
                it.previous();
                it.add(data);
                flag = false;
                break;
            }
        }
        if(flag){
            it.add(data);
        }
    }

    private int getBucketIndex(float data) {
        return (int) data;
    }

    public void insertSort(List<Float> bucket, float data) {
        ListIterator<Float> it = bucket.listIterator();
        boolean flag = true;
        while(it.hasNext()){
            if(data < it.next()){
                it.previous();
                it.add(data);
                flag = false;
                break;
            }
        }
        if(flag){//如果没有在中间插入，则在链表末尾插入
            bucket.add(data);
        }
    }
}
