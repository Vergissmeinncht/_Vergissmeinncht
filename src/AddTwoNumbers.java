/*
给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        ListNode l3 = new ListNode();
        l3 = l1;
        while (true) {
            l1.val = l1.val + l2.val;
            if (l1.val >= 10) {
                l1.val %= 10;
                if (l1.next != null) {
                    l1.next.val++;
                } else {
                    ListNode l4 = new ListNode();
                    l4.val = 1;
                    l1.next = l4;
                }
            }
            if (l1.next == null || l2.next == null) {
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2.next != null) {
            l1.next = l2.next;
            if (l1.val >= 10) {
                l1.val %= 10;
                l1.next.val++;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (l1.val >= 10) {
                l1.val %= 10;
                if (l1.next != null) {
                    l1.next.val++;
                } else {
                    ListNode l4 = new ListNode();
                    l4.val = 1;
                    l1.next = l4;
                }
            }
            l1 = l1.next;
        }
        return l3;
    }
}
