package string;

/**
 * Prefix Tree字典树
 */
public class Trie {
    private class Node{
        boolean isEnd;//是否存在以本节点结尾的单词
        Node[] son = new Node[26];
        private Node() {
            isEnd = false;
        }
    }
    Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        char[] chars = word.toCharArray();
        Node p = root;
        for (char c : chars){
            int u = c - 'a';
            if (p.son[u]==null) p.son[u]=new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }
    public boolean search(String word){
        Node p = root;
        char[] chars = word.toCharArray();
        for (char c : chars){
            int u = c - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return p.isEnd;
    }
    public boolean startsWith(String prefix){
        Node p = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars){
            int u = c - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return true;
    }
}
