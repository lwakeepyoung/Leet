package dataStructure;

import java.util.LinkedHashMap;

public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        refresh(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        //将最近使用过的key放在链表尾部
        if(cache.containsKey(key)){
            cache.put(key,value);
            refresh(key);
            return;
        }
        //说明满了，要淘汰头节点
        if(cache.size()>=this.capacity){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //放到链表尾部
        cache.put(key,value);
    }

    private void refresh(int key){
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
}
