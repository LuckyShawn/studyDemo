package algorithm.leetcode.mid;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/22 0022
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null || root.left == null && root.right == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isOrderLeft = true; //左排序
        while (!queue.isEmpty()) {
            int n = queue.size();
            Deque<Integer> levelList = new LinkedList<Integer>();   //双端队列
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(node.val);
                }else{
                    levelList.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}