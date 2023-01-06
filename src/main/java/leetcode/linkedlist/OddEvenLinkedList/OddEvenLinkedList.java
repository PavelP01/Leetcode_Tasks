package leetcode.linkedlist.OddEvenLinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        new OddEvenLinkedList().oddEvenList(l1);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenListFirst = head.next;
        if (evenListFirst == null) {
            return head;
        }

        ListNode oddListLast = head;

        int evenAdjacentCount = 0;

        outerloop:
        while (true) {
            evenListFirst = oddListLast.next;
            ListNode evenListLast = evenListFirst;
            for (int i = 0; i < evenAdjacentCount; i++) {
                evenListLast = evenListLast.next;
                if (evenListLast == null) {
                    break outerloop;
                }
            }
            evenAdjacentCount++;
            ListNode nearestFreeOdd = evenListLast.next;
            if (nearestFreeOdd == null) {
                break;
            }

            //rearrange
            evenListLast.next = nearestFreeOdd.next;
            nearestFreeOdd.next = evenListFirst;
            oddListLast.next = nearestFreeOdd;
            oddListLast = nearestFreeOdd;
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
