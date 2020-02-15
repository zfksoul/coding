package algorithms.dp;

/**
 * 青蛙一次跳1格或2格或n格，给定格数，有几种跳法
 * F(n)=F(n-1)+F(n-2)+...+F(1)=2*F(n-1)
 */
public class JumpFloor1 {
    public static void main(String[] args){
        JumpFloor1 o = new JumpFloor1();
        System.out.println(o.myJumpFloor1(3));
    }
    public int myJumpFloor1(int target) {
        if (target < 1){
            return 0;
        } else if (target == 1){
            return 1;
        } else {
            return 2 * myJumpFloor1(target - 1);
        }
    }
}
