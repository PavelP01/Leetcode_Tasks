package leetcode.linkedlist.addtwonumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4, l1_3);
        ListNode l1_2 = new ListNode(2, l1_4);

        ListNode l2_4 = new ListNode(4);
        ListNode l2_6 = new ListNode(6, l2_4);
        ListNode l2_5 = new ListNode(5, l2_6);


        ListNode result = new AddTwoNumbers().addTwoNumbers(l1_2, l2_5);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();

        ListNode currentNode = resultHead;

        int extra = 0;

        while (l1 != null || l2 != null) {
            int sum = extra;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            extra = sum / 10;
            currentNode.val = sum % 10;
            ListNode next;
            if (l1 == null && l2 == null) {
                if (extra == 1) {
                    next = new ListNode(1);
                } else {
                    next = null;
                }
            } else {
                next = new ListNode();
            }
            currentNode.next = next;
            currentNode = next;
        }
        return resultHead;
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

