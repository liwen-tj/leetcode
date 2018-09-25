/**
 * 环形链表
 * 
 * 给定一个链表，判断链表中是否有环。
 * 
 * 进阶： 你能否不使用额外空间解决此题？
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head != null && head.next == head){
            return true;
        }
        ListNode f = head, s = head;
        boolean flag = false;
        while (f!=null && f.next!=null) {
            s = s.next;
            f = f.next.next;
            if (s == f){
                flag = true;
                break;
            }
        }
        return flag;
    }
}