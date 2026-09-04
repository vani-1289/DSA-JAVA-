/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        //finding the mid element
        public ListNode middlenode(ListNode head){
            ListNode s = head;
            ListNode f = head;

            while(f != null && f.next != null){
                s = s.next;
                f = f.next.next;
            }
            return s;
        }

        //reversing the LL
        public ListNode reverselist(ListNode head){
            ListNode prev = null;
            ListNode pres = head;

            while(pres!=null){
                ListNode next = pres.next;
                pres.next = prev;
                prev = pres;
                pres = next;
            }return prev;
        }

        //checking and comparing ispallindrome or not
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
            return true;
            }
            ListNode mid = middlenode(head);  
            ListNode headsec = reverselist(mid); // Reverse second half
            ListNode rereversehead = headsec;

            //compared both halfs
            while(headsec!=null){
                if(head.val != headsec.val){
                    return false;
                }
                head = head.next;
                headsec= headsec.next;  
            }
            // Restore original list
            reverselist(rereversehead);

            return true;
    }
}