package algorithms.others;

import java.util.HashMap;

public class RandomPool<K> {
    HashMap<K, Integer> keyIndexMap;
    HashMap<Integer, K> indexKeyMap;
    Integer size;

    public static void main(String[] args){
        RandomPool o = new RandomPool<String>();
        o.insert("a");
        o.insert("b");
        o.insert("c");
        o.insert("d");
        System.out.print(o.getRandom());
        System.out.print(o.getRandom());
        System.out.println(o.getRandom());
        o.remove("a");
        o.remove("d");
        System.out.print(o.getRandom());
        System.out.println(o.getRandom());
        o.insert("z");
        o.insert("x");
        o.insert("c");
        System.out.print(o.getRandom());
        System.out.println(o.getRandom());
    }
    public RandomPool(){
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }
    public void insert(K key){
        if (!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key, size);
            indexKeyMap.put(size++, key);
        }
    }
    public K getRandom(){
        if (size == 0){
            return null;
        }
        int randomIndex = (int) (Math.random() * size);
        return indexKeyMap.get(randomIndex);
    }
    public void remove(K key){
        if (keyIndexMap.containsKey(key)){
            int deleteIndex = keyIndexMap.get(key);
            int lastIndex = --size;
            K lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.remove(key);
            indexKeyMap.remove(deleteIndex);
            keyIndexMap.put(lastKey, deleteIndex);
            indexKeyMap.put(deleteIndex, lastKey);
        }
    }
}
