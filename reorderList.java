// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class Solution {
    public void reorderList(ListNode head) {
        // null case
        if(head == null || head.next == null || head.next.next == null) return;

        // Logic
        ListNode slow = head;
        ListNode fast = head;
        
        // Finding mid
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reversing LL and assign fast to first node
       fast = reverse(slow.next);
        
        slow.next = null;
        slow = head;
        
        // Merging linklist
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        // Reverse logic
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        
        return curr;
    }
}