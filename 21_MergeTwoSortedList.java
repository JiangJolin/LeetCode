/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode ans;
        ListNode ans_cur;
        ListNode pointer;
        if(l1.val <= l2.val){
            ans = l1;
            ans_cur = l1;
            pointer = l2;
        }else{
            ans = l2;
            ans_cur = l2;
            pointer = l1;
        }
        while(ans_cur.next != null && pointer != null){
            if(ans_cur.next.val <= pointer.val){
                ans_cur = ans_cur.next;
            }else{
                ListNode temp = ans_cur.next;
                ans_cur.next = pointer;
                pointer = temp;
            }
        }
        if(pointer != null){
            ans_cur.next = pointer;
        }
        return ans;
    }
}