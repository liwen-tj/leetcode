/**
 * 合并两个有序链表
 * 
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例： 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 不借助额外的空间
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode p = l1, q = l2;
        ListNode head = p.val < q.val ? l1 : l2;
        if (p.val < q.val) {
            p = p.next;
        } else {
            q = q.next;
        }

        ListNode h = head;
        while (p != null && q != null) {
            if(p.val < q.val){
                h.next = p;
                h = h.next;
                p = p.next;
            }
            else{
                h.next = q;
                h = h.next;
                q = q.next;
            }
        }

        h.next = p != null ? p : q;

        return head;
    }
}