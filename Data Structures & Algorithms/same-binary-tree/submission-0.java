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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base cases: both are null (true), one is null and the other is not (false), both are not null, but dont have the same value
        if (p== null && q == null){
            return true;
        }

        if (p==null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        // if all cases are passed then p and q are not null and have the same value, now we have to check their left and right nodes

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;

    }
}
