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

    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = middlenode(head);

        ListNode hf = head;
        ListNode hs = reverselist(mid);

        //rearrange
        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        //next of tail to null
        if(hf!=null){
            hf.next = null;
        }

    }
}