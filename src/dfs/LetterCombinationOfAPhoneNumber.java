package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    private String[] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args){
        LetterCombinationOfAPhoneNumber o = new LetterCombinationOfAPhoneNumber();
        System.out.println(Arrays.toString(o.letterCombinations(String.valueOf(23))));
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
}
