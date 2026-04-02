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
    int pre_idx = 0; // points to the current root in preorder array
    HashMap<Integer, Integer> indices = new HashMap<>(); //maps each value in inorder array to its index so we can split left/right subtrees quicker


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        } // initialiser map
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l , int r){
        if (l > r) return null;

        int root_val = preorder[pre_idx++]; //gets the root value but also increments root_val
        TreeNode root = new TreeNode(root_val); //creates the root
        int mid = indices.get(root_val); //gets the mid index of the mid in inorder (we can split up the the call with left and right)
        root.left = dfs(preorder, l, mid-1); //left subtree
        root.right = dfs(preorder, mid + 1, r); //right subtree
        return root;


    }
}
