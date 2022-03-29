package algorithm.leetcode.leetCodeTop.mid;


/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/27 0027
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){ //公共祖先是root的边界情况
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);    //root左子节点递归找p，q
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);  //root右子节点递归找p，q
        if(leftNode == null){   //右侧找到，遇到节点 p 或 q 时返回。从底至顶回溯
            return rightNode;
        }

        if(rightNode == null){  //左侧找到，遇到节点 p 或 q 时返回。从底至顶回溯
            return leftNode;
        }
        return root;    //遇到节点 p 或 q 时返回。从底至顶回溯
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

    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}