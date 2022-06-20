// Time Complexity: O(m+n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // taking length of headA
        ListNode h1 = headA;
        int len1 = 0;
        while(h1.next != null) {
            h1 = h1.next;
            len1++;    
        }
        
        // taking length of headB
        int len2 = 0;
        ListNode h2 = headB;
        while(h2.next != null) {
            h2 = h2.next;
            len2++;    
        }
        
        // re-assinging the head at start pos.
        h1 = headA;
        h2 = headB;
        
        // Taking difference and moving h1 or h2
        int diff = Math.abs(len2 - len1);
        int tempCount = 0;
        while(tempCount < diff) {
            if(len1 < len2)
                h2 = h2.next;
            else
                h1 = h1.next;
                
                tempCount++;
        }
        
        // matching h1 & h2 when they meet returning one of the h1 or h2
        while(h1 != h2){
            h2 = h2.next;
            h1 = h1.next;
        }
        
        return h1;
    }
}