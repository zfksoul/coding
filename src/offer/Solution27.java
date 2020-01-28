package offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
* 
*
* @author zfk
* @date 2019年10月25日 下午11:43:04 
* 
*/
public class Solution27 {
    public static void main(String[] args) {
        Solution27 so = new Solution27();
        String s = "axgasdxzsf";
        char[] c = so.sort(s);
        for(int i = 0; i<c.length;i++) {
            System.out.print(c[i]);
        }
        System.out.println("--------------");
        System.out.println("bba".compareTo("bab"));
        System.out.println("a".compareTo("a"));
        System.out.println("b".compareTo("a"));
    }
    public ArrayList<String> Permutation(String str) {
        char[] c = sort(str);
        ArrayList<String> res = new ArrayList<String>();
        
       // String s = String.valueOf(b);
        //res.add(s);
        return res;
    }
    public char[] sort(String str) {
        char tmp;
        char[] c = str.toCharArray();
        for(int i = 0;i<c.length;i++) {
            for(int j =0;j<c.length-1;j++) {
                if(c[j]>c[j+1]) {
                    tmp = c[j+1];
                    c[j+1]=c[j];
                    c[j]=tmp;
                }
            }
        }
        return c;
    }
}
class Mycomparator implements Comparator<String>{
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
