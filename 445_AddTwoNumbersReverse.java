/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode ans = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            carry += s1.isEmpty()? 0: s1.pop();
            carry += s2.isEmpty()? 0: s2.pop();
            ListNode node = new ListNode(carry % 10);
            carry /= 10;

            node.next = ans;
            ans = node;
        }
        return ans;
    }
}