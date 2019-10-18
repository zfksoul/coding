package algorithms;

/**
* 
*
* @author zfk
* @date 2019年10月18日 下午7:39:32 
* 
*/
public class Solution8 {
	public int JumpFloor(int target) {
		if(target==0 || target==1) {
			return 1;
		}else {
			return JumpFloor(target-1)+JumpFloor(target-2);
		}
    }
}
