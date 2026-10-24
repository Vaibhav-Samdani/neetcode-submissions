/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder sb;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        sb = new StringBuilder();
        sDfs(root);
        return sb.toString();
    }

    void sDfs(TreeNode root){
        if(root == null){
            sb.append("n,");
            return;
        }

        sb.append(root.val).append(",");
        sDfs(root.left);
        sDfs(root.right);
    }

    int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        i = 0;
        String[] arr = data.split(",");
        TreeNode root = dDfs(arr);

        return root;
    }

    TreeNode dDfs(String[] data){

        if(i >= data.length) return null;

        String curr = data[i++];
        if(curr.equals("n")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = dDfs(data);
        root.right = dDfs(data);

        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
