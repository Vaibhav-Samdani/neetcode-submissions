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
        StringBuilder ans = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();

                if (curr == null) {
                    ans.append("n,");
                    continue;
                }

                ans.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("n")) return null;
        String[] arr = data.split(",");

        if(arr.length == 0 || arr[0].equals("n")) return null;

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        int i = 1;
        q.offer(root);

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (!arr[i].equals("n")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if(!arr[i].equals("n") && i < arr.length){
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }

            i++;
        }

        return root;
    }
}
