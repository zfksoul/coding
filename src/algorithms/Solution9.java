package algorithms;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月18日 下午7:39:32
 * 
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
