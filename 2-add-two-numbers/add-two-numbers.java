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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr = new ListNode();
        ListNode ans = itr;
        int carry = 0;

        while(l1 != null && l2 != null){

            ListNode n1 = new ListNode();
            int tmp = l1.val + l2.val + carry;

            
            carry = tmp / 10;
            n1.val = tmp % 10;

            itr.next = n1;
            itr = itr.next;

            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null){
            int tmp = l1.val + carry;

            carry = tmp / 10;
            ListNode n1 = new ListNode();


            n1.val = tmp % 10;
            itr.next = n1;
            itr = itr.next;

            l1 = l1.next;

        }

         while(l2 != null){
            int tmp = l2.val + carry;

            carry = tmp / 10;
            ListNode n1 = new ListNode();


            n1.val = tmp % 10;
            itr.next = n1;
            itr = itr.next;

            l2 = l2.next;

        }

        while( carry > 0){
            ListNode n1 = new ListNode();

            n1.val = carry % 10;
            itr.next = n1;
            itr = itr.next;

            carry /= 10;
        }


        return ans.next;
    }
}