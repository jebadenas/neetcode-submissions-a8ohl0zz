/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
