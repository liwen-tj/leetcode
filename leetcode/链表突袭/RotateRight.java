/**
 * 旋转链表
 * 
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1: 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步:
 * 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 示例 2: 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL 向右旋转 3 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        // 算一下链表的长度
        ListNode h = head;
        int len = 0;
        while(h!=null){
            len += 1;
            h = h.next;
        }
        // 双指针法
        k = k % len;
        if (k == 0)
            return head;
        int b = len - k;
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        for (int i = 0; i < b - 1; ++i) {
            fast = fast.next;
            slow = slow.next;
        }
        h = slow.next;
        slow.next = null;
        fast.next = head;
        return h;
    }
}