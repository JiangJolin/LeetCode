//执行用时 :38 ms, 在所有 Java 提交中击败了68.82%的用户
//内存消耗 :47.8 MB, 在所有 Java 提交中击败了100.00%的用户
import java.util.*;

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> next_max;

    public MaxQueue() {
        queue = new LinkedList<>();
        next_max = new LinkedList<>();
    }
    
    public int max_value() {
        return next_max.peek() == null ? -1 : next_max.peek();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while(next_max.size() > 0 && next_max.peekLast() < value){
            next_max.pollLast();
        }
        next_max.offerLast(value);
    }
    
    public int pop_front() {
        try{
            int front = queue.remove();
            if(next_max.peek() == front){
                next_max.poll();
            }
            return front;
        }
        catch (Exception e) {
            return -1;
        }
    }
}