package cn.qingtangbaimian.algorthm.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/">第101题 对称二叉树</a>
 * @date 2023-05-16 22:40:56
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        System.out.println(iteration(root));
    }

    /**
     * 方法一：递归法
     * 思路是：将要对比的左右两棵子树分别传入进去，根据题目要求是对称，那就表明左子树最左侧的叶子节点要和右子树最右侧的叶子节点对称，
     * 同样的，那么可以得出左子树最右侧的叶子节点和右子树最左侧的叶子节点也需要挤不下比对是否对称
     * 先判断左右都为空为true，然后在第一个条件的基础上，任意一个为空为false
     * 然后先比较当前层左右树是否对称，然后依次对比left.right和right.left，left.left和right.right，这两个随便那个在前面都可以
     * @param root 根节点
     * @return 是否对称
     */
    public static boolean recursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    /**
     * 方法二：迭代法
     * 思路是：使用一个双端队列，将要对比的左右两棵子树分别传入进去，根据题目要求是对称，那就表明左子树最左侧的叶子节点要和右子树最右侧的叶子节点对称，
     * 先从队列的头部和尾部分别弹出一个字节点，判断左右节点的值是否对称，如对称，则依次将左子树的右节点和左节点添加到队列的头部
     * 然后再依次将右子树的左节点和右节点添加到队列的尾部，从而得到（左.左, 左.右, 右.左，右右）
     * @param root 根节点
     * @return 是否对称
     */
    static boolean iteration(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (null == leftNode && null == rightNode) {
                continue;
            }
            if (null == leftNode || null == rightNode) {
                return false;
            }
            if (leftNode.val == rightNode.val) {
                deque.addFirst(leftNode.right);
                deque.addFirst(leftNode.left);
                deque.addLast(rightNode.left);
                deque.addLast(rightNode.right);
                continue;
            }
            return false;
        }
        return true;
    }

    static boolean recursion(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val == right.val) {
            if (recursion(left.right, right.left)) {
                return recursion(left.left, right.right);
            }
        }
        return false;
    }
}
