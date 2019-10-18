package algorithms;

/**
* 
*
* @author zfk
* @date 2019年10月18日 下午7:39:32 
* 
*/
public class Solution7 {
	public int Fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
    }
}
