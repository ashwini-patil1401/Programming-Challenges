/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        
        if(null == head || head.next == null)
            return head;
        
        ListNode node = head.next;
        ListNode start = head;
        ListNode last = node.next;
        
        while(node!=null) {
            last = node.next;
            node.next = head;
            head = node;
            start.next = last;
            node = start.next;
        }

        return head;
        
    }
}
