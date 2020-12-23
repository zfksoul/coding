package string;

/**
 * 整数转英文表示
 * 0<= num <= 2^31 - 1 = 2147483648-1
 */
public class IntegerToEnglishWords {
    private String[] small = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
                              "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                              "Eighteen","Nineteen"};
    private String[] decade = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private String[] big = {"Billion","Million","Thousand",""};

    public static void main(String[] args){
        IntegerToEnglishWords o = new IntegerToEnglishWords();
        System.out.println(o.numberToWords(1234000678));
        System.out.println(o.numberToWords1(1234000678));
    }

    public String numberToWords(int num){
        if (num == 0) return small[0];
        StringBuilder res = new StringBuilder();
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j++){
            if (num >= i){
                res.append(getPart(num/i)).append(big[j]).append(" ");
                num %= i;
            }
        }
        return res.toString().trim();
    }

    public String getPart(int num){
        StringBuilder res = new StringBuilder();
        if (num >= 100){
            res.append(small[num/100]+" Hundred ");
            num %= 100;
        }
        if (num == 0) return res.toString();
        if (num >= 20){
            res.append(decade[num/10]+' ');
            num %= 10;
        }
        if (num == 0) return res.toString();
        res.append(small[num]+' ');
        return res.toString();
    }

    public String numberToWords1(int num){
        if (num == 0) {
            return small[0];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j++){
            if (num >= i){
                res.append(getPart1(num / i)).append(big[j]).append(' ');
                num %= i;
            }
        }
        return res.toString().trim();
    }
    public String getPart1(int num){
        StringBuilder res = new StringBuilder();
        if (num > 100){
            res.append(small[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num == 0) return res.toString();
        if (num > 20){
            res.append(decade[num / 10]).append(' ');
            num %= 10;
        }
        if (num == 0) return res.toString();
        res.append(small[num]).append(' ');
        return res.toString();
    }


}
