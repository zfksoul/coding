package offer;

/**
 * 数组中出现次数超过一半的数字
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int cnt = 1;
        int res = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (res == arr[i]){
                cnt++;
            } else if (cnt == 0){
                res = arr[i];
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == res){
                cnt++;
            }
        }
        if (cnt > arr.length / 2){
            return res;
        } else {
            return 0;
        }
    }
}
