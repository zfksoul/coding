package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在9键键盘中输入数字，返回所有可能的字符组合
 */
public class LetterCombinationOfAPhoneNumber {
    private String[] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args){
        LetterCombinationOfAPhoneNumber o = new LetterCombinationOfAPhoneNumber();
        System.out.println(Arrays.toString(o.letterCombinations("23")));
        System.out.println(Arrays.toString(o.letterCombinations1("23")));
        System.out.println(Arrays.toString(o.letterCombinations2("23")));
    }
    public String[] letterCombinations2(String digits){
        if (digits == null || digits.length() == 0){
            return new String[]{};
        }
        String[] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] res = {""};
        for (char d : digits.toCharArray()){
            ArrayList<String> now = new ArrayList<>();
            for (char c : str[d - '2'].toCharArray()){
                for (String s : res){
                    now.add(s + c);
                }
            }
            res = now.toArray(new String[0]);
        }
        return res;
    }
    public String[] letterCombinations(String digits){
        if (digits.isEmpty()) return new String[]{};
        String[] res = {""};
        for (char d : digits.toCharArray()){
            List<String> now = new ArrayList<>();
            for (char c : str[d-'2'].toCharArray()){
                for (String s : res){
                    now.add(s+c);
                }
            }
            res = now.toArray(new String[0]);
        }
        return res;
    }
    public String[] letterCombinations1(String digits){
        String[] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        boolean[][] record = new boolean[str.length][];
        for (int i = 0; i < str.length; i++){
            record[i] = new boolean[str[i].length()];
        }
        process(digits, str, s, res, record, 0);
        return res.toArray(new String[0]);
    }

    private void process(String digits, String[] str, StringBuilder s, ArrayList<String> res, boolean[][] record, int n) {
        if (n == digits.length()){
            res.add(s.toString());
            return;
        }
        int k = digits.charAt(n) - '2';
        for (int i = 0; i < record[k].length; i++){
            s.append(str[k].charAt(i));
            process(digits, str, s, res, record, n +1);
            s.deleteCharAt(s.length() - 1);
        }
        /*for (int i = 0; i < record[k].length; i++){
            if (record[k][i] == false){
                record[k][i] = true;
                s.append(str[k].charAt(i));
                process(digits, str, s, res, record, n +1);
                s.deleteCharAt(s.length() - 1);
                record[k][i] = false;
            }
        }*/
    }
}
