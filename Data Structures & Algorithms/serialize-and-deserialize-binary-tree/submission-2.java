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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialise(root, res);
        System.out.println(res);
        return String.join(",", res); //turn into a string
    }

    private void dfsSerialise(TreeNode node, List<String> res){
        //preorder traversal
        if (node == null) {
            res.add("N"); //null we append N
            return;
        }
        res.add(String.valueOf(node.val)); //we append the string value of the current node
        dfsSerialise(node.left,res); // we call this on the left 
        dfsSerialise(node.right, res); // we call this on the right
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};//global variable to index in the string array
        return dfsDeserialise(vals, i);
    }

    private TreeNode dfsDeserialise(String[] vals, int[] i){
        if (vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }


        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]])); //we create the node from the value at the index provided from the global variable
        i[0]++; //we increment it afterwards
        node.left = dfsDeserialise(vals, i); //call it on the left to get the left node
        node.right = dfsDeserialise(vals, i); // call it on the right to get right node

        return node;
    }


}
