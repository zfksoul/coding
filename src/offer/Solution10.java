package offer;

/**
* 
*
* @author zfk
* @date 2019年10月18日 下午7:39:32 
* 
*/
public class Solution10 {
	public int RectCover(int target) {
        if(target==0){
            return 0;
        }else if(target==1) {
			return 1;
		}else if(target==2) {
			return 2;
		}else {
			return RectCover(target-1)+RectCover(target-2);
		}
    }
}
