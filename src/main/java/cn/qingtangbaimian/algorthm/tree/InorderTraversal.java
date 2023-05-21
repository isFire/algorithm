package cn.qingtangbaimian.algorthm.tree;

import java.util.*;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">第94题 二叉树的中序遍历</a>
 * @date 2023-05-14 22:35:35
 */

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(dfs(root));
    }

    public static List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>(10);
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (stack.size() > 0 || null != cur) {
            if (null == cur) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                cur = pop.right;
            }
            stack.push(cur);
            cur = cur.left;
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(10);
        if (null == root) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }


}
