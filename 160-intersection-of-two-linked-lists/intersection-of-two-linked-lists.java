/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = length(headA);
        int len2 = length(headB);
        if(len1<len2){
            int increment = len2 - len1;
            while(increment > 0){
                temp2 = temp2.next;
                increment--;
            }
        }
        else{
            int increment = len1 - len2;
            while(increment > 0){
                temp1 = temp1.next;
                increment--;
            }
        }
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
    public int length(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}