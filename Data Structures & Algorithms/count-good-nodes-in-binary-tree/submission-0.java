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
    int ans;
    public int goodNodes(TreeNode root) {
        ans = 0;

        count(root,Integer.MIN_VALUE);
        return ans;
    }

    void count(TreeNode root, int max){
        if(root == null) return;

        if(root.val >= max){
            ans++;
            max = root.val;
        }

        
        count(root.left,max);
        count(root.right,max);
    }
}
