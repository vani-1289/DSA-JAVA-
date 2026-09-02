// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         int length = 0;
//         ListNode fast = head;
//         ListNode slow = head;

//         while(fast!=null && fast.next!=null){
//             fast = fast.next.next;
//             slow = slow.next;
//             if(fast == slow){
//                 length = hasCycle(slow);
//                 break;

//             }
//             if(length ==0){
//                 return null;
//             }

//             //finding the start node
//             ListNode f = head;
//             ListNode s = head;

//             while(length > 0){
//                 s = s.next;
//                 length--;
//             }
//             //keep moving both forward and they will meet at cycle start
//             while(f!=s){
//                 f = f.next;
//                 s = s.next;

//             }
//             return s;
//         }

        
//     }
// }
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;        // slow moves 1 step
            fast = fast.next.next;   // fast moves 2 steps

            if (slow == fast) {
                return true;         // cycle exists
            }
        }

        return false;                // no cycle
    }
}