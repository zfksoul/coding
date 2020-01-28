package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 找到所有长度为10的，在字符串中出现次数大于等于2的子串
 * input:"AAAAACCCCCAAAAACCCCCCAAAAAGGGTT"
 * output:["AAAAACCCCC","CCCCCAAAAA"]
 * 把所有长度为10的字符串插入哈希表，在哈希表中找到所有出现次数大于等于2的字符串输出
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        RepeatedDNASequences o = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTT";
        System.out.println(Arrays.toString(o.findRepeatedDnaSequences(s)));
    }
    public String[] findRepeatedDnaSequences(String s){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i + 10 < s.length(); i++){
            String str = s.substring(i,i+10);
            if (map.containsKey(str)) map.put(str,map.get(str)+1);
            else map.put(str,1);
            if (map.get(str) == 2) res.add(str);
        }
        return res.toArray(new String[0]);
    }
}
