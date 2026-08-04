class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums, target, 0, new ArrayList<>());

        return ans;
    }

    void helper(int[] nums, int target, int start, List<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            curr.add(nums[i]);

            helper(nums, target - nums[i], i + 1, curr);

            curr.remove(curr.size() - 1);
        }
    }
}
