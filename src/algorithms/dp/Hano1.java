package algorithms.dp;

/**
 * 只能相邻移动
 */
public class Hano1 {
    public static void main(String[] args){
        Hano1 o = new Hano1();
        System.out.println(o.hanoProblem(3, "left", "mid", "right"));
    }
    public int hanoProblem(int n, String left, String mid, String right){
        if (n < 1){
            return 0;
        }
        return process(n, left, mid, right, left, right);
    }

    private int process(int n, String left, String mid, String right, String from, String to) {
        if (n == 1){
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("move 1 from " + from + " to " + mid);
                System.out.println("move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)){
            String another = from.equals(left) || to.equals(left) ? right : left;
            int part1 = process(n - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("move " + n + " from " + from + " to " + to);
            int part3 = process(n - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(n - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("move " + n + " from " + from + " to " + mid);
            int part3 = process(n - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("move " + n + " from " + mid + " to " + to);
            int part5 = process(n - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
