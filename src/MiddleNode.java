/*
给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
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

    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode a = new ListNode();
        a = head;
        while (a != null) {
            length++;
            a = a.next;
        }
        length /= 2;
        while (length > 0 && head != null) {
            head = head.next;
            length--;
        }
        return head;
    }
}
