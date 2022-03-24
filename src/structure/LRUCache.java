package structure;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache {
    private int cap;

    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int cap){
        this.cap = cap;
        cache = new LinkedHashMap<>(cap);
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            cache.put(key,value);
            refresh(key);
        }
        if (cache.size() >= cap) {
            Integer removeKey = cache.keySet().iterator().next();
            cache.remove(removeKey);
        }
        cache.put(key,value);
    }

    public Integer get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        refresh(key);
        return cache.get(key);
    }

    private void refresh(int key) {
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
}
