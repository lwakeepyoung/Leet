import java.util.LinkedHashMap;

public class LRUCache {

    private Integer cap;
    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap(capacity);
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        refresh(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            refresh(key);
            return;
        }
        //淘汰头节点
        if(cache.size()>=this.cap){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //将新节点加到尾部
        cache.put(key,value);
    }
    private void refresh(int key) {
        Integer value = cache.get(key);
        //删除，重新加入， 这样尾部的为最新使用过的
        cache.remove(key);
        cache.put(key,value);
    }
}
