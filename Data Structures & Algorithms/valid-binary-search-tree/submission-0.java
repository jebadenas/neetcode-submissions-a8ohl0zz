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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long left, long right){
        if (root == null){
            return true;
        }

        if (!((left < root.val) && (right > root.val))){
            return false;
        }
        //going left so left stays the same 
        // going right so right stays the same
        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right); 

    }
}
