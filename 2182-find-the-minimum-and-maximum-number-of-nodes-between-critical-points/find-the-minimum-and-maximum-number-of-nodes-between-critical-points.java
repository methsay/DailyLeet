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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int firstCriticalPointPosition = 0;
        int previousCriticalPointPosition = 0;
        int i = 1;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = 0;
        while(current.next != null){
            if((current.val < prev.val && current.val < current.next.val) || (current.val > prev.val && current.val > current.next.val)){
                if(previousCriticalPointPosition == 0){
                    previousCriticalPointPosition = i;
                    firstCriticalPointPosition = i;
                }
                else{
                    minDistance = Math.min(minDistance,i-previousCriticalPointPosition);
                    previousCriticalPointPosition = i;
                }
            }
            i++;
            prev = current;
            current = current.next;
        }
        if(minDistance == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[] {minDistance , previousCriticalPointPosition - firstCriticalPointPosition };
    }
}