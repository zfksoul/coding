package offer;

/**
* 
*
* @author zfk
* @date 2019年10月18日 下午7:39:32 
* 
*/
public class Solution11 {
	public int NumberOf1(int n) {
        int count=0;
		int i=1;
		while(i!=0) {
			if((n&i)!=0) {
				count++;
			}
			i=i<<1;
		}
		return count;
    }
}	
