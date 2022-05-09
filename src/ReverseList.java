/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode sHead = new ListNode(0,head);
        ListNode node = head;
        while(node.next!=null) {
            ListNode t = new ListNode();
            t.val = node.next.val;
            if(node.next.next!=null){
               node.next = node.next.next;
            }else {
                node.next=null;
            }
            t.next = sHead.next;
            sHead.next = t;
        }
        return head;
    }
}
