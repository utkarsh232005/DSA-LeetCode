class Solution {
    public int minSwaps(String s) {
        int cnt0 = 0, cnt1 = 0, miss0 = 0, miss1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        if (Math.abs(cnt0 - cnt1) > 1) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            // Check against Pattern A (starts with 0)
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') miss0++;
            } else {
                if (s.charAt(i) != '1') miss0++;
            }
            
            // Check against Pattern B (starts with 1)
            if (i % 2 == 0) {
                if (s.charAt(i) != '1') miss1++;
            } else {
                if (s.charAt(i) != '0') miss1++;
            }
        }
        if (cnt0 == cnt1) {
            return Math.min(miss0, miss1) / 2;
        }

        if (cnt0 > cnt1) {
            return miss0 / 2;
        }

        return miss1 / 2;
    }
}