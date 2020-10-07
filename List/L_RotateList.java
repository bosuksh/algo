package org.example.leetcode;

public class RotateList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        int cnt = 1;
        ListNode curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
            cnt++;
        }
        k %= cnt;
        while(k != 0) {
            k--;
            curNode = head;
            while(curNode.next.next != null) {
                curNode = curNode.next;
            }
            curNode.next.next = head;
            head = curNode.next;
            curNode.next= null;
        }
        return head;
    }
}
