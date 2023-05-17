package cn.qingtangbaimian.algorthm.list;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/">第83题</a>
 * @date 2023-05-13 22:51:28
 */
public class DelDup {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        deleteDuplicates(node);
    }

    /**
     * 解题思路，设置一个指针，指向下一个元素，从头结点开始
     * 如果指针的值和指针下一个节点的值相等，则设置指针的下一个节点为下下个节点
     * @param head 重复链表
     * @return 去重后的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode next = head;
        while (null != next.next) {
            if (next.val == next.next.val) {
                next.next = next.next.next;
                continue;
            }
            next = next.next;
        }
        return head;
    }
}
