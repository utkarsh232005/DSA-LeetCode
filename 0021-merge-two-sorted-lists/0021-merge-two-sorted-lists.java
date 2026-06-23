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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode ans;
        if(l1.val <= l2.val){
            ans = l1;
        }else{
            ans = l2;
        }
        while(l1 != null && l2 != null){
            ListNode temp = null;
            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1= l1.next;
            }
            if (temp != null) {
                temp.next = l2;
            }
            ListNode t = l1;
            l1 = l2;
            l2 =t;
        }
        return ans;
    }
}