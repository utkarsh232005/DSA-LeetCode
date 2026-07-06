class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distanceKHelper(root, target, k);
        return ans;
    }
    private int distanceKHelper(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            down(root, k);
            return 0;
        }
        int dl = distanceKHelper(root.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k) {
                ans.add(root.val);
            } else {
                down(root.right, k - dl - 2);
            }
            return 1 + dl;
        }

        int dr = distanceKHelper(root.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                ans.add(root.val);
            } else {
                down(root.left, k - dr - 2);
            }
            return 1 + dr;
        }

        return -1;
    }
    public void down(TreeNode root, int k) {
        if (root == null || k < 0) return;
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        down(root.left, k - 1);
        down(root.right, k - 1);
    }
}