package cn.qingtangbaimian.algorthm.tree;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="https://leetcode.cn/problems/same-tree/">第100题 相同的树</a>
 * @date 2023-05-15 23:15:26
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(isSameTree(root, root));
    }


    /**
     * 这道题本身其实没什么难的，两棵树使用同一种遍历方式，前序/中序/后序都可以，
     * 完了就是每次递归都去 == 一下，如果不等于直接返回false就好了
     * @param p 树1
     * @param q 树2
     * @return p和q是否相等
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            }
        }
        return false;
    }
}
