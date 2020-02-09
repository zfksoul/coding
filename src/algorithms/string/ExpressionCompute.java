package algorithms.string;

import java.util.Arrays;
import java.util.LinkedList;

public class ExpressionCompute{
    public static void main(String[] args){
        ExpressionCompute o = new ExpressionCompute();
        LinkedList<String> q = new LinkedList<>();
        String str = "3+(1+3)*(10-5)-2*2";
        q.addLast("11");
        q.addLast("+");
        q.addLast("12");
        q.addLast("-");
        q.addLast("3");
        q.addLast("*");
        q.addLast("4");
        q.addLast("/");
        q.addLast("2");
        System.out.println(o.getValue(str));
        System.out.println(o.getValue1(str));
    }
    public int getValue(String str){
        if (str == null || str.equals("")){
            return 0;
        }
        char[] c = str.toCharArray();
        return value(c, 0)[0];
    }
    public int getValue1(String str){
        if (str == null || str.equals("")){
            return 0;
        }
        char[] c = str.toCharArray();
        return value1(c, 0)[0];
    }
    public int[] value1(char[] c, int i) {
        LinkedList<String> q = new LinkedList<>();
        int pre = 0;
        int[] res = null;
        while (i < c.length && c[i] != ')'){
            if (c[i] >= '0' && c[i] <= '9'){
                pre = pre * 10 + c[i++] - '0';
            } else if (c[i] != '('){
                addNum(q, pre);
                q.addLast(String.valueOf(c[i++]));
                pre = 0;
            } else {
                res = value1(c, i + 1);
                pre = res[0];
                i = res[1] + 1;
            }
        }
        addNum(q, pre);
        return new int[]{getNum1(q), i};
    }
    public int getNum1(LinkedList<String> q){
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!q.isEmpty()){
            cur = q.pollFirst();
            if (cur.equals("+")){
                add = true;
            } else if (cur.equals("-")){
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : -num;
            }
        }
        return res;
    }

    private void addNum(LinkedList<String> q, int num) {
        if (!q.isEmpty()){
            int cur = 0;
            String top = q.pollLast();
            if (top.equals("+") || top.equals("-")){
                q.addLast(top);
            } else {
                cur = Integer.valueOf(q.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        q.addLast(String.valueOf(num));
    }

    public int[] value(char[] c, int i) {
        LinkedList<String> q = new LinkedList<>();
        int num = 0;
        int[] res = null;
        while (i < c.length && c[i] != ')'){
            if (c[i] >= '0' && c[i] <= '9'){
                num = num * 10 + c[i++] - '0';
            } else if (c[i] != '('){
                q.addLast(String.valueOf(num));
                q.addLast(String.valueOf(c[i++]));
                num = 0;
            } else {
                res = value(c, i + 1);
                num = res[0];
                i = res[1];
            }
        }
        q.addLast(String.valueOf(num));
        return new int[] {getNum(q), i + 1};
    }

    public int getNum(LinkedList<String> q){
        boolean add = true;
        int num = 0;
        int res = 0;
        String cur;
        while (!q.isEmpty()){
            cur = q.pollFirst();
            if (cur.equals("+")){
                res += add ? num : -num;
                num = 0;
                add = true;
            } else if (cur.equals("-")){
                res += add ? num : -num;
                num = 0;
                add = false;
            } else if (cur.equals("*")){
                num = num * Integer.valueOf(q.pollFirst());
            } else if (cur.equals("/")){
                num = num / Integer.valueOf(q.pollFirst());
            } else {
                num = Integer.valueOf(cur);
            }
        }
        res += add ? num : -num;
        return res;
    }

}
