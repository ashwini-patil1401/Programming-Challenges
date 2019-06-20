/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(null == head || head.next == null) {
            return false;
        }
        
        
        ListNode first = head, second = head.next;
        
        while(first!=null && null!= second ){
            if(first == second)
                return true;
            
            first = first.next;
            if( second.next!=null) {
                second = second.next.next;
            } else {
                break;
            }
        }
        
        return false;
        
    }
}
