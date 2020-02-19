package algorithms.string;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class DictionaryOrderArrangement {
    public static void main(String[] args){
        DictionaryOrderArrangement o = new DictionaryOrderArrangement();
        String s = "cba";
        StringBuilder sb = new StringBuilder("cba");
        System.out.println(o.Permutation(sb));
        System.out.println(o.Permutation1(s));
        System.out.println(o.Permutation2(s));
        System.out.println(o.Permutation3(s));
    }
    public ArrayList<String> Permutation3(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < chars.length; i++){
            ArrayList<String> now = new ArrayList<>();
            for (char c : chars){
                for (String s : res){
                    if (!s.contains(String.valueOf(c))){
                        now.add(c + s);
                    }
                }
            }
            res = new ArrayList<>(now);
        }
        return res;
    }
    public ArrayList<String> Permutation2(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        char[] c = str.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();//TreeSet按序保存
        ArrayList<String> res = new ArrayList<>();
        boolean[] record = new boolean[c.length];
        process(c, record, 0, set, sb);
        res.addAll(set);
        return res;
    }

    private void process(char[] c, boolean[] record, int len, TreeSet<String> set, StringBuilder sb) {
        if (len == c.length){
            set.add(new String(sb));
            return;
        }

        for (int i = 0; i < record.length; i++){
            if (record[i] == false){
                record[i] = true;
                sb.append(c[i]);
                process(c, record, len + 1, set, sb);
                sb.deleteCharAt(sb.length() - 1);
                record[i] = false;
            }
        }
    }
    public ArrayList<String> Permutation1(String str) {
        TreeSet<String> set = new TreeSet<>();
        ArrayList<String> res = new ArrayList<>();
        if (str == null){
            return res;
        }
        if (str.length() == 1){
            res.add(str);
            return res;
        }
        char[] c = str.toCharArray();
        Arrays.sort(c);
        for (int i = 0; i < c.length; i++){
            if (i == 0 || c[i] != c[0]){
                swap(c, 0, i);
                ArrayList<String> list = Permutation1(new String(c, 1, c.length - 1));
                for (String s : list){
                    set.add(new String(String.valueOf(c[0]) + s));
                }
                swap(c, 0, i);
            }
        }
        res.addAll(set);
        return res;
    }
    public ArrayList<String> Permutation(StringBuilder str) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if (str == null){
            return res;
        }
        if (str.length() == 1){
            res.add(str.toString());
            return res;
        }
        for (int i = 0; i < str.length(); i++){
            if (i == 0 || str.charAt(i) != str.charAt(0)){
                swap(str, 0, i);
                ArrayList<String> list = Permutation(new StringBuilder(str.substring(1)));
                for (String s : list){
                    set.add(str.substring(0, 1) + s);
                }
                swap(str, 0, i);
            }
        }
        res.addAll(set);
        String[] s = res.toArray(new String[0]);
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        res = new ArrayList<String>(Arrays.asList(s));
        return res;
    }

    private void swap(char[] c, int l, int r) {
        char tmp = c[l];
        c[l] = c[r];
        c[r] = tmp;
    }
    private void swap(StringBuilder str, int l, int r) {
        char tmp = str.charAt(l);
        str.setCharAt(l, str.charAt(r));
        str.setCharAt(r, tmp);
    }
}
