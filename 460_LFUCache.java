import java.util.*;
class Unit{
    final int key;
    int value;
    int frequency;
    int time;
    public Unit(int key, int value, int op){
        this.key = key;
        this.value = value;
        frequency = 0;
        time = op;
    }
}
class LFUCache {
    private PriorityQueue<Unit> lfu_queue;
    private Map<Integer, Unit> cache;
    private final int capacity;
    int count;
    int op_count;

    static Comparator<Unit> cmp = new Comparator<Unit>() {
        public int compare(Unit a, Unit b) {
            return a.frequency == b.frequency ? a.time - b.time : a.frequency - b.frequency;
        }
    };

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        lfu_queue = new PriorityQueue<>(capacity + 1, cmp);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity == 0) return -1;
        op_count++;
        if(cache.containsKey(key)){
            Unit temp = cache.get(key);
            lfu_queue.remove(temp);
            temp.frequency += 1;
            temp.time = op_count;
            lfu_queue.add(temp);

            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        op_count++;
        Unit temp;
        if(cache.containsKey(key)){
            temp = cache.get(key);
            lfu_queue.remove(temp);
            temp.frequency += 1;
            temp.time = op_count;
            temp.value = value;
        }else{
            temp = new Unit(key, value, op_count);
            if(count == capacity){
                Unit out = lfu_queue.poll();
                cache.remove(out.key);
                
            }else{
                count ++;
            }
        }
        cache.put(key, temp);
        lfu_queue.add(temp);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */