package algorithms.dp;

/**
 * 1*2的砖块覆盖2*n的地面，有多少种覆盖方法
 */
public class RectangleCover {
    public int RectCover(int target) {
        if (target < 1){
            return 0;
        } else if (target == 1){
            return 1;
        } else if (target == 2){
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
