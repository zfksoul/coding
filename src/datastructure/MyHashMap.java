package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap {
    ArrayList<ArrayList<Pair>> h;
    int N = 20011;

    public static void main(String[] args){
        MyHashMap o = new MyHashMap();
    }
    public MyHashMap(){
        h = new ArrayList<ArrayList<Pair>>(N);
    }
    public Pair find(int key){
        int t = key % N;
        List<Pair> list = h.get(t);
        for (Pair p : list){
            if (p.key == key) return p;
        }
        return null;
    }
    public void put(int key, int value){
        Pair p = find(key);
        if (p != null) p.value = value;
        int t = key % N;
        List<Pair> list = h.get(t);
        list.add(new Pair(key, value));
    }
    public int get(int key){
        Pair p = find(key);
        if (p != null) return p.value;
        return -1;
    }
    public void remove(int key){
        Pair p = find(key);
        if (p != null){
            int t = key % N;
            List<Pair> list = h.get(t);
            list.remove(p);
        }
    }

}
class Pair{
    public int key;
    public int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
