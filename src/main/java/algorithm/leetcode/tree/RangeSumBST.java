package algorithm.leetcode.tree;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: RangeSumBST 938. 二叉搜索树的范围和
 * @projectName studyDemo
 * @description: 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *  
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32   7+10+15
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23  6+7+10
 * 提示：
 *
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 * 通过次数56,794提交次数71,293
 *
 * @date 2021/4/27
 */
public class RangeSumBST {
    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
