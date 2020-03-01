package offer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 扫描整个数组，当扫描到下标为 i 的数字时，首先比较该数字（m）是否等于 i，如果是，则接着扫描下一个数字；
 * 如果不是，则拿 m 与第 m 个数比较。如果 m 与第 m 个数相等，则说明出现重复了；
 * 如果 m 与第 m 个数不相等，则将 m 与第 m 个数交换，将 m "归位"，再重复比较交换的过程，直到发现重复的数
 */
public class Solution50 {
    public static void main(String[] args){
        Solution50 o = new Solution50();
        int[] arr = {0,1,3,1,3,5,5};
        int[] duplication = {0};
        o.duplicate(arr, arr.length, duplication);
        System.out.println(duplication[0]);
    }
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0){
            return false;
        }
        int l = 0;
        for (int i = 0; i < length; i++){
            if (numbers[i] == i){
                continue;
            } else if (numbers[i] == numbers[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            } else {
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int l, int r) {
        int tmp = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = tmp;
    }
}
