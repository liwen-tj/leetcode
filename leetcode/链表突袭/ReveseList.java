/**
 * 反转链表: 反转一个单链表。
 * 
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 * 
 * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        if(head==null || head.next==null) return head; // 只有一个节点
        ListNode q = head.next, m = head.next.next;

        head.next = null;
        while(m != null){
            q.next = p;
            p = q;
            q = m;
            m = m.next;
        }
        q.next = p;
        return q;
    }
}


