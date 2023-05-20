package cn.qingtangbaimian.algorthm.tree;

import java.util.*;

/**
 * @author <a href="mailto:is_fire_subscribe@hotmail.com">清汤白面</a>
 * @description <a href="/">第102题二叉树的层序遍历</a>
 * @date 2023-05-20 22:44:40
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));
    }

    /**
     * 解题思路，这道题要求进行层序遍历，限定死了只能使用队列
     * 按照BFS的思路，先遍历root结点，同时在弹出第一个元素之后，获取当前队列的长度，然后分别将当前元素的左右节点放入队列，
     * 接下来看看队列是否已经空了，如果空了就进行下一次遍历了
     * 如果接下来的遍历中，第一个元素取出来后依然有值，说明是同级元素，基于队列的先进先出原理，遍历len-1次，然后依次弹出，重复node节点动作
     * @param root 二叉树
     * @return 遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int len = treeNodes.size() - 1;
            processNode(treeNodes, integers);
            for (int i = 0; i < len; i++) {
                processNode(treeNodes, integers);
            }
            result.add(integers);
        }
        return result;
    }

    private static void processNode(Queue<TreeNode> treeNodes, List<Integer> integers) {
        TreeNode node = treeNodes.poll();
        integers.add(node.val);
        if (Objects.nonNull(node.left)) {
            treeNodes.add(node.left);
        }
        if (Objects.nonNull(node.right)) {
            treeNodes.add(node.right);
        }
    }
}
