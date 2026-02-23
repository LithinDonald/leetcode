class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head
    }
}