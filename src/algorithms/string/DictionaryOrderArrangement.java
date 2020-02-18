package algorithms.string;

import java.util.*;

public class DictionaryOrderArrangement {
    public static void main(String[] args){
        DictionaryOrderArrangement o = new DictionaryOrderArrangement();
        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(o.Permutation(sb));
    }

    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null){
            return res;
        }
        if (str.length() == 1){
            res.add(str);
            return res;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++){
            if (i == 0 || c[i] != c[0]){
                swap(c, 0, i);
                ArrayList<String> list = Permutation1(new String(c, 1, c.length - 1));
                for (String s : list){
                    res.add(new String(String.valueOf(c[0]) + s));
                }
                swap(c, 0, i);
            }
        }
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        return res;
    }
    public ArrayList<String> Permutation(StringBuilder str) {
        ArrayList<String> res = new ArrayList<>();
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
                    res.add(str.substring(0, 1) + s);
                }
                swap(str, 0, i);
            }
        }

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
