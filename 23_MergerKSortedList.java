/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // static Comparator<ListNode> cmp = new Comparator<ListNode>() {
    //     public int compare(ListNode a, ListNode b) {
    //         return a.val - b.val;
    //     }
    // };
    // public ListNode mergeKLists(ListNode[] lists) {
    //     PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(cmp);
    //     for(int i = 0; i < lists.length; i++){
    //         if(lists[i] != null) pq.offer(lists[i]);
    //     }
    //     if(pq.size() < 1) return null;
    //     if(pq.size() == 1) return pq.element();
    //     ListNode ans = pq.element();
    //     ListNode cur = pq.poll();
    //     while(!pq.isEmpty()){
    //         if(cur.next != null){
    //             pq.offer(cur.next);
    //         }
    //         cur.next = pq.poll();
    //         cur = cur.next;
    //     }
    //     return ans;
    // }
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

}