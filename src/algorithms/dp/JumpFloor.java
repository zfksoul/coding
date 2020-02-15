package algorithms.dp;

/**
 * 青蛙一次跳一格或一次跳2格，给定格数有几种跳法
 */
public class JumpFloor {
    public static void main(String[] args){
        JumpFloor o = new JumpFloor();
        System.out.println(o.myJumpFloor(3));
    }
    public int myJumpFloor(int target) {
        if (target < 1) {
            return 0;
        } else if(target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return myJumpFloor(target - 1) + myJumpFloor(target - 2);
        }
    }
}
