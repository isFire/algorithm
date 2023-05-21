package cn.qingtangbaimian.algorthm.tree;

import java.util.*;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">第144题二叉树的前序遍历</a>
 * @date 2023-05-19 23:38:33
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(dfs(root));
    }

    public static List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>(3);
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (Objects.nonNull(node.right)) {
                stack.push(node.right);
            }
            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 这个真没啥好说的，前序遍历、中序遍历、后序遍历递归的经典范例
     * @param root 树
     * @return 结果集
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(3);
        if (Objects.isNull(root)) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
