package algorithms.others;

import java.util.HashMap;

public class SetAllHashMap<K, V> {
    private HashMap<K, MyValue<V>> map;
    private long time;
    private MyValue<V> setAll;

    public SetAllHashMap(){
        this.map = new HashMap<K, MyValue<V>>();
        this.time = 0;
        this.setAll = new MyValue<V>(null, -1);
    }
    public boolean containsKey(K key){
        return this.map.containsKey(key);
    }
    public void put(K key, V value){
        this.map.put(key, new MyValue<V>(value, this.time++));
    }
    public void setAll(V value){
        this.setAll = new MyValue<V>(value, this.time++);
    }
    public V get(K key){
        if (this.containsKey(key)){
            if (this.map.get(key).getTime() > this.setAll.getTime()){
                return this.map.get(key).getValue();
            } else {
                return this.setAll.getValue();
            }
        } else {
            return null;
        }
    }


}
class MyValue<V>{
    private V value;
    private long time;

    public MyValue(V value, long time){
        this.value = value;
        this.time = time;
    }
    public V getValue(){
        return this.value;
    }
    public long getTime(){
        return this.time;
    }
}
