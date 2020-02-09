package algorithms.dp;

import java.util.Stack;

public class Hano2 {
    public static void main(String[] args){
        Hano2 o = new Hano2();
        System.out.println(o.hanoProblem(3, "left", "mid", "right"));
    }
    public int hanoProblem(int n, String left, String mid, String right){
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = n; i > 0; i--){
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rs.size() != n + 1){
            step += fStackTotStack(record, Action.MToL, Action.LToM, ls, ms, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
        }
        return step;
    }

    /**
     *
     * @param record 全局变量
     * @param preNoAct 上一步不能发生的动作
     * @param nowAct
     * @param fs
     * @param ts
     * @param from 检查是否可行
     * @param to  检查是否可行
     * @return
     */
    public int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fs, Stack<Integer> ts, String from, String to) {
        //不能走上一步的逆过程，不能违反小压大，排除三种情况
        if (record[0] == preNoAct || fs.peek() >= ts.peek()){
            return 0;
        }
        ts.push(fs.pop());
        System.out.println("move " + ts.peek() + " from " + from + " to " + to);
        record[0] = nowAct;
        return 1;
    }


    public static enum Action{
        No,
        LToM,
        MToL,
        MToR,
        RToM
    }
}

