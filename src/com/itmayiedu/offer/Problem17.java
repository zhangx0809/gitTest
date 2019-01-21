package com.itmayiedu.offer;

public class Problem17 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode second1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode second2 = new ListNode();
        ListNode third2 = new ListNode();
        head1.nextNode = second1;
        head2.nextNode = second2;
        second2.nextNode = third2;
        head1.data = 1;
        second1.data = 3;
        head2.data = 2;
        second2.data = 2;
        third2.data = 4;
        Problem17 test = new Problem17();
        ListNode result = test.mergeList(head1, head2);
        System.out.println(result.nextNode.nextNode.nextNode.nextNode.data);
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.data < head2.data) {
            mergeHead = head1;
            mergeHead.nextNode = mergeList(head1.nextNode, head2);
        } else {
            mergeHead = head2;
            mergeHead.nextNode = mergeList(head1, head2.nextNode);
        }
        return mergeHead;
    }
}

class ListNode {
    int data;
    ListNode nextNode;
}