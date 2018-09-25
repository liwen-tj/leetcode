/**
 * 环形链表 II
 * 
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 说明：不允许修改给定的链表。
 * 
 * 进阶： 你是否可以不用额外空间解决此题？
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
    public ListNode detectCycle(ListNode head) {
        ListNode f = head, s = head;
        if(head != null && head.next == head){
            return head;
        }
        boolean flag = false;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                flag = true;
                break;
            }
        }
        if(flag){
            s = head;
            while(s != f){
                s = s.next;
                f = f.next;
            }
            return s;
        }
        else{
            return null;
        }
    }
}