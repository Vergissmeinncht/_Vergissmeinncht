/*
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) { this.val =val;}
        ListNode(int val,ListNode next) { this.val = val; this.next = next;}
    }
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node!=null) {
            length++;
            node = node.next;
        }
        int a = (length+1)/2;
        int b = (length+1)/2;
        node = head;
        while(a>0) {
            node = node.next;
            a--;
        }
        node = reverseList(node);
        while(node!=null) {
            if(head.val!= node.val) {
                return false;
            }
            head=head.next;
            node=node.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode sHead = new ListNode(0,head);
        while(head.next!=null) {
            ListNode t = new ListNode();
            t.val = head.next.val;
            if(head.next.next!=null){
                head.next = head.next.next;
            }else {
                head.next=null;
            }
            t.next = sHead.next;
            sHead.next = t;
        }
        return sHead.next;
    }
}
