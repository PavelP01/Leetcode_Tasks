package leetcode.linkedlist.removenode;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode earlyPointer = head;
        ListNode latePointer = head;

        for (int i = 0; i < n; i++) {
            earlyPointer = earlyPointer.next;
        }
        if (earlyPointer == null) {
            return latePointer.next;
        }

        earlyPointer = earlyPointer.next;
        ListNode beforeLatePointer = latePointer;

        while (earlyPointer != null) {
            earlyPointer = earlyPointer.next;
            beforeLatePointer = beforeLatePointer.next;
        }

        ListNode targetNode = beforeLatePointer.next;
        beforeLatePointer.next = targetNode.next;

        return head;
    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class SubListNode extends ListNode {
        public SubListNode() {
            System.out.println();
            //super(1);
        }
    }
}
