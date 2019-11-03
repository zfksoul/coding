package Sort;

/**
* 
*
* @author zfk
* @date 2019年10月30日 下午11:42:24 
* 
*/
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,5,41,11,23,63,21,54,6,4,2,1};
        RadixSort o = new RadixSort();
        arr = o.myRadixSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public int[] myRadixSort(int[] arr) {
        int[] c = new int[9];
        int[] res = new int[arr.length];
        for (int div = 1; div <= 10; div *= 10) {
            //计数排序
            for (int i = 0; i < arr.length; i++) {
                c[(arr[i]/div)%10]++;
            }
            for (int i = 1; i < c.length; i++) {
                c[i] += c[i-1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                c[(arr[i]/div)%10]--;
                res[c[(arr[i]/div)%10]] = arr[i];
            }
            //更新数组顺序
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res[i];
            }
            //计数归零
            for (int i = 0; i < c.length; i++) {
                c[i] = 0;
            }
        }
        return res;
    }

}
