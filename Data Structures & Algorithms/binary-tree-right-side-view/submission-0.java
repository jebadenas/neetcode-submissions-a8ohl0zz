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
    public List<Integer> rightSideView(TreeNode root) {
        // bfs?


        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> res = new ArrayList<>();
        

        while (!q.isEmpty()){
            TreeNode rightNode = null;
            int curSize = q.size();

            for (int i = 0; i < curSize; i++){
                TreeNode node = q.poll();

                if (node != null){
                    rightNode = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }


            if (rightNode != null){
                res.add(rightNode.val);
            }

        }

        return res;

    }
}
