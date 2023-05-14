package cn.qingtangbaimian.algorthm.list;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/"></a>
 * @date 2023-05-08 11:19:50
 */
public class MergeLinkedList {


    /**
     * 有点绕，不过思路应该是，两个list内部都是有序的，那么需要一个个的作对比
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的升序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // l1为空的时候返回l2
        if (null == list1) {
            return list2;
        }
        // l2为空的时候返回l1
        if (null == list2) {
            return list1;
        }
        // l1 l2都不为空就继续对比
        if (list1.val <= list2.val) {
            // 如果l1小于或等于l2，那就判断l1的下一个值是不是也小于l2，把最小的哪个返回回来做l1的next节点
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        // 否则l2比l1大，那就让l2的下一个值继续对比，把最小的哪个返回回来做l2的next节点
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }



}
