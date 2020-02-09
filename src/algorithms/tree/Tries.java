package algorithms.tree;

import java.util.HashMap;

public class Tries{
    private HashMap<Character, Tries> children = new HashMap<>();
    private boolean end = false;
    public boolean addAndCheck(char[] chs, int i){
        if (end){//当前节点是一个字符串的结尾，其他字符串是当前字符串的前缀
            return true;
        }
        if (i == chs.length){
            end = true;
            return !children.isEmpty();//当前节点结束，后续还有节点，说明当前字符串是其他字符串的前缀
        }
        if (!children.containsKey(chs[i])){
            children.put(chs[i], new Tries());
        }
        return children.get(chs[i]).addAndCheck(chs, i + 1);
    }
}
