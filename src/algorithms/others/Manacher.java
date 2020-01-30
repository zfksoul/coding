package algorithms.others;

/**
 * 给定字符串，返回最长回文子串的长度
 */
public class Manacher {
    public static void main(String[] args){
        Manacher o = new Manacher();
        String str = "abcbbcab";
        System.out.print(o.maxLcpsLength2(str));
    }
    public int maxLcpsLength(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++){
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1){
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if (i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
    public int maxLcpsLength2(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++){
            pArr[i] = i < pR ? Math.min(pArr[2 * index - i], pR - i -1) : 0;
            int l = i - pArr[i] - 1;
            int r = i + pArr[i] + 1;
            while (l >= 0 && r < charArr.length && charArr[l] == charArr[r]){
                    pArr[i]++;
                    l--;
                    r++;
            }
            if (r > pR){
                pR = r;
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max;
    }
    public int maxLcpsLength1(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);//处理字符串，间隔插入'#'
        int[] pArr = new int[charArr.length];//以i为中心的回文串半径
        int index = -1;//右边界为pR的回文串的中心位置
        int pR = -1;//回文串最右边界的下一个位置
        int res = Integer.MIN_VALUE;//结果
        for (int i = 0; i < charArr.length; i++){
            if (i < pR){
                if (i + pArr[2 * index - i] < pR - 1){
                    pArr[i] = pArr[2 * index - i];
                } else if (i + pArr[2 * index - i] == pR - 1){
                    int l = i - pArr[2 * index - i] - 1;
                    int r = pR;
                    while (l >= 0 && r < pArr.length && charArr[l] == charArr[r]){
                        l--;
                        r++;
                    }
                    if (r > pR) {
                        pR = r;
                        index = i;
                    }
                    pArr[i] = r - i - 1;
                    res = Math.max(res, pArr[i]);
                } else {
                    pArr[i] = pR - i - 1;
                }
            }else{
                int l = i - 1;
                int r = i + 1;
                while (l >= 0 && r < charArr.length && charArr[l] == charArr[r]){
                    l--;
                    r++;
                }
                pR=r;
                pArr[i] = pR - i - 1;
                index = i;
                res = Math.max(res, pArr[i]);
            }
        }
        return res;
    }
    public char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

}
