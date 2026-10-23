import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;     // sum of v
    private long[] sumSq;   // sum of v^2
    private long[] lazy;    // lazy addition tag

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + len * (val * val % MOD) % MOD) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void pushUp(int node) {
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        if (ql <= mid) {
            update(2 * node, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update(2 * node + 1, mid + 1, r, ql, qr, val);
        }
        pushUp(node);
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastPos = new HashMap<>();
        long totalAns = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastPos.getOrDefault(nums[i], -1);
            
            update(1, 0, n - 1, prev + 1, i, 1);
            
            totalAns = (totalAns + sumSq[1]) % MOD;
            
            lastPos.put(nums[i], i);
        }

        return (int) totalAns;
    }
}