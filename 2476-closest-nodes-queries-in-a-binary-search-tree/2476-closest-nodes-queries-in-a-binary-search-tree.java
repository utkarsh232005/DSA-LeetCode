class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);
        List<List<Integer>> ans = new ArrayList<>();
        int n = sortedList.size();
        for (int query : queries) {
            int floor = -1;
            int ceil = -1;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = sortedList.get(mid);
                if (val == query) {
                    floor = val;
                    ceil = val;
                    break;
                } else if (val < query) {
                    floor = val;
                    left = mid + 1;
                } else {
                    ceil = val;
                    right = mid - 1;
                }
            }
            ans.add(Arrays.asList(floor, ceil));
        }
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}