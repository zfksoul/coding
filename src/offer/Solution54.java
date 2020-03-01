package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {
    Queue<Character> q = new LinkedList<>();
    char[] c = new char[256];
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (c[ch] == 0){
            q.offer(ch);
        }
        c[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (q.size() > 0){
            if (c[q.peek()] > 1){
                q.poll();
            } else {
                return q.peek();
            }
        }
        return Character.valueOf('#');
    }
}
