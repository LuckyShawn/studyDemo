package algorithm.leetcode.tree;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: MinDiffInBST 783. 二叉搜索树节点最小距离（easy）
 * @projectName studyDemo
 * @description:
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * @date 2021/4/13
 */
public class MinDiffInBST {
    int pre;
    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
