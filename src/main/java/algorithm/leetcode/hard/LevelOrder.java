package algorithm.leetcode.hard;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/21 0021
 */
public class LevelOrder {

    /**
     * BFS层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果
        List<List<Integer>> res = new ArrayList<>();

        //定义队列--先入先出
        Queue<TreeNode> queue = new ArrayDeque();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<Integer>(); //记录层级

            for (int i = 0; i < n; i++) {   //遍历一层中的数
                TreeNode node = queue.poll();//此时队列中存的是上一层的节点，n=上一层的个数
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
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
}
