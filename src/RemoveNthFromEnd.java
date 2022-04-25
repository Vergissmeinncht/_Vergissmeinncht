/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        int length = 0;
        ListNode b = head;
        while (b != null) {
            length++;
            b = b.next;
        }
        int p = length - n;
        while (a != null && p > 1) {
            p--;
            a = a.next;
        }
        if (p == 0) {
            head = head.next;
        } else {
            a.next = a.next.next;
        }
        return head;
    }
}
