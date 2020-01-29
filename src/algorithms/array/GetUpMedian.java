package algorithms.array;

public class GetUpMedian {
    public static void main(String[] args){
        GetUpMedian o = new GetUpMedian();
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = {1,2,3,5,7,8,9,19};
        System.out.print(o.findKthNum(arr1, arr2, 10));
    }

    /**
     * 给定2个有序数组长度分别为m和n，找到第k大的数
     * 时间复杂度O(log(min{m,n}))
     */
    public int findKthNum(int[] arr1, int[] arr2, int k){
        if (arr1 == null || arr2 == null){
            throw new RuntimeException("arr is invalid");
        }
        if (k < 1 || k > arr1.length + arr2.length){
            throw new RuntimeException("k is invalid");
        }
        int[] longArr = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shortArr = arr1.length < arr2.length ? arr1 : arr2;
        int lenL = longArr.length;
        int lenS = shortArr.length;
        if (k <= lenS){
            return findProcess(shortArr, 0, k - 1, longArr, 0, k - 1);
        } else if (k > lenL){
            if (shortArr[k - lenL - 1] >= longArr[lenL - 1]){
                return shortArr[k - lenL - 1];
            } else if (longArr[k - lenS - 1] >= shortArr[lenS - 1]){
                return longArr[k - lenS - 1];
            } else {
                return findProcess(shortArr, k - lenL, lenS - 1,
                        longArr, k - lenS, lenL - 1);
            }
        } else {
            if (longArr[k - lenS - 1] >= shortArr[lenS - 1]){
                return longArr[k - lenS - 1];
            } else {
                return findProcess(shortArr, 0, lenS - 1,
                        longArr, k - lenS, k - 1);
            }
        }
    }
    public int myGetUpMedian(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null || arr1.length != arr2.length){
            throw new RuntimeException("arr is invalid");
        }
        return findProcess(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
    }
    /**
     * 找到2个长度为n的数组的上中位数
     * 时间复杂度O(logn)
     */
    public int findProcess(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2) {
        if (start1 == end1){
            return Math.min(arr1[start1], arr2[start2]);
        }
        //元素个数为奇数，offset为0，偶数为1
        int offset = ((end1 - start1 + 1) & 1) ^ 1;
        int mid1 = (start1 + end1) >> 1;
        int mid2 = (start2 + end2) >> 1;
        if (arr1[mid1] > arr2[mid2]){
            return findProcess(arr1, start1, mid1, arr2, mid2 + offset, end2);
        } else if (arr1[mid1] < arr2[mid2]){
            return findProcess(arr1, mid1 + offset, end1, arr2, start2, mid2);
        } else {
            return arr1[mid1];
        }
    }
}
