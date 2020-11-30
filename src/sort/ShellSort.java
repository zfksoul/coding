package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午8:36:05
 * 
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        ShellSort o = new ShellSort();
        arr = o.myShellSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public int[] myShellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {//注意i++，使得gap分出的每组都得到排序
                int tmp = arr[i];
                int j;
                for (j = i - gap; j >= 0; j -= gap){
                    if (arr[j] > tmp){
                        arr[j+ gap] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+ gap] = tmp;
            }
        }
        return arr;
    }
    public int[] myShellSort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                int tmp = arr[i];
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
        }
        return arr;
    }

    public int[] myShellSort2(int[] arr) {
        for (int inc = arr.length / 2; inc > 0; inc /= 2){
            for (int i = inc; i < arr.length; i++){
                int j = i - inc;
                int tmp = arr[i];
                while (j >= 0 && arr[j] > tmp){
                    arr[j + inc] = arr[j];
                    j -= inc;
                }
                arr[j + inc] = tmp;
            }
        }
        return arr;
    }




}
