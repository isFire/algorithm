package cn.qingtangbaimian.algorthm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">第145题 二叉树的后序遍历</a>
 * @date 2023-05-21 15:41:55
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(dfs(root));
    }

    public static List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (null != cur || !stack.isEmpty()) {
            if (null == cur) {
                // 左子树为空，处理右子树的数据
                TreeNode node = stack.peek();
                if (null == node.right || last == node.right) {
                    last = stack.pop();
                    result.add(last.val);
                    continue;
                }
                cur = node.right;
                continue;
            }
            stack.push(cur);
            cur = cur.left;
        }
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
