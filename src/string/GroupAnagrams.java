package string;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * 将字符串分组，含有相同字母的字符串分到一组，顺序可以不同
 * input:["eat","tea","tan","ate","nat","bat"]
 * output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * n个字符串，每个字符串平均长度m，排序的时间复杂度O(n*mlogm)，
 * 哈希表插入效率是O(m)，有n个字符串，哈希表时间复杂度O(n*m)
 * 时间复杂度：O(n*mlogm + n*m)
 */
public class GroupAnagrams {
    public static void main(String[] args){
        List<String> strs = new ArrayList();
        strs.add("eat");
        strs.add("tea");
        strs.add("tan");
        strs.add("ate");
        strs.add("nat");
        strs.add("bat");
        GroupAnagrams o = new GroupAnagrams();
        System.out.println(o.myGoutpAndAnagrams(strs));
        System.out.println(o.myGoutpAndAnagrams1(strs));
    }
    public List<List<String>> myGoutpAndAnagrams(List<String> strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String str :strs){
            char[] c = str.toCharArray();
            sort(c,0,c.length-1);
            //String key = Arrays.toString(c);
            //String key = new String(c);
            String key = String.valueOf(c);
            if (map.get(key) == null){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()){
            List<String> list = new ArrayList<>(map.get(key));
            res.add(list);
        }
        return res;
    }
    public List<List<String>> myGoutpAndAnagrams1(List<String> strs){
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String s : strs){
            char[] c = s.toCharArray();
            sort(c,0, s.length() - 1);
            String key = Arrays.toString(c);
            if (!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    private void sort(char[] c, int l, int r) {
        if (c == null || c.length == 0) return;
        if (l < r) {
            int pivot = partition(c, l, r);
            sort(c, l, pivot - 1);
            sort(c, pivot + 1, r);
        }
    }

    private int partition(char[] c, int l, int r) {
        int p = l+1;
        for (int i = p; i <= r; i++){
            if (c[i] < c[l]){
                swap(c,i,p);
                p++;
            }
        }
        swap(c,l,p-1);
        return p-1;
    }
    private void swap(char[] c, int l, int r){
        char tmp = c[l];
        c[l] = c[r];
        c[r] = tmp;
    }

}
