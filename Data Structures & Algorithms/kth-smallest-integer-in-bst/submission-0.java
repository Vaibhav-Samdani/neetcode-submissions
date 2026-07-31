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
    int n;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        n = 0;
        dfs(root,k);
        return ans;
    }

    void dfs(TreeNode root, int k){
        if(root == null) return;

        dfs(root.left,k);
        n++;
        if(n==k) ans = root.val;
        dfs(root.right,k);
    }
}
