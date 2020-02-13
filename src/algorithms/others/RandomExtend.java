package algorithms.others;

public class RandomExtend {

    public int rand1To5(){
        return (int) ((Math.random() * 5) + 1);
    }

    public int rand1To7(){
        int num = 0;
        do{
            num = ((rand1To5() - 1) * 5) + rand1To5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }
    public int rand01p(){
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }
    public int rand0To1(){
        int num;
        do{
            num = rand01p();
        } while (num == rand01p());
        return num;
    }
    public int rand0To3(){
        return rand0To1() * 2 +rand0To1();
    }
    public int rand1To6(){
        int num = 0;
        do{
            num = rand0To3() * 4 + rand0To3();
        } while (num > 11);
        return num % 6 + 1;
    }
    public int rand1ToM(int m){
        return (int) ((Math.random() * m) + 1);
    }

    public int rand1ToN(int m, int n){
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;

    }
    //把n转成m进制数
    private int[] getMSysNum(int n, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (n != 0){
            res[index--] = n % m;
            n = n / m;
        }
        return res;
    }
    //产生0~n-1的数，用m进制表示
    private int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0){
            start++;
        }
        int index = start;
        boolean lastEqual = true;//如果上一位nMSys和res相等，则下一位res不能大于nMSys，否则可以大于
        while (index < nMSys.length){
            res[index] = rand1ToM(m) - 1;
            if (lastEqual){
                if (res[index] > nMSys[index]){
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }
    //把m进制数转成10进制数
    private int getNumFromMSysNum(int[] randNum, int m) {
        int res = 0;
        for (int i = 0; i < randNum.length; i++){
            res += res * m + randNum[i];
        }
        return res;
    }
}
