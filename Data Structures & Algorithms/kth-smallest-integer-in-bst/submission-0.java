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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || curr != null){
            while (curr != null){ //we keep going left until we cant anymore
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop(); //before this curr = null
            k--;
            if (k==0){
                //we are kth element
                return curr.val; 
            }
            curr = curr.right; //if this node exists then then it would come before the node at the top of stack
        }

        return -1;
    }
}
