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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root,ans,1);
        return ans;
    }

    void solve(TreeNode root, List<List<Integer>> ans, int count){
        if(root == null) return;

        if(ans.size() < count){
            ans.add(new ArrayList<>());
        }

        ans.get(count-1).add(root.val);
        solve(root.left,ans,count+1);
        solve(root.right,ans,count+1);
    }
}
