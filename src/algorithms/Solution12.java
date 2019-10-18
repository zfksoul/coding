package algorithms;

/**
* 
*
* @author zfk
* @date 2019年10月18日 下午8:29:28 
* 
*/
public class Solution12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
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
