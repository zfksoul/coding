package algorithms.others;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index < 1){
            return 0;
        }
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int i = 1;
        int[] res = new int[index];
        res[0] = 1;
        for (; i < index; i++){
            res[i] = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[index - 1];
    }
}
