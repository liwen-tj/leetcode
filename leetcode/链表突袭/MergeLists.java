/**
 * 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution{
    private static Comparator<ListNode>  comp =new Comparator<ListNode>() {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val-o2.val;
		}
	};
	
    public static ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comp);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                ListNode temp = node;
                node = node.next;
                temp.next = null;
                queue.add(temp);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode t = result;
        while (!queue.isEmpty()) {
            t.next = queue.poll();
            t = t.next;
        }
        return result.next;
    }
}
