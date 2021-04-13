package algorithm.leetcode.tree;

/**
 * @author Shawn
 * @title: TreeNode
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/4/13
 */
public class TreeNode {
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
