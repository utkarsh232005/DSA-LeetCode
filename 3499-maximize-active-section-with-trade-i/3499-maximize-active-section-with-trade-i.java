class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        s = "1" + s + "1";
        int n = s.length();
        int i = 0;
        int ans = totalOnes;
        while (i < n && s.charAt(i) == '1') {
            i++;
        }
        int leftZeros = 0;

        while (i < n && s.charAt(i) == '0') {
            leftZeros++;
            i++;
        }

        while (i < n) {
            while (i < n && s.charAt(i) == '1') {
                i++;
            }
            int rightZeros = 0;

            while (i < n && s.charAt(i) == '0') {
                rightZeros++;
                i++;
            }

            if (rightZeros == 0) {
                break;
            }

            ans = Math.max(
                ans,
                totalOnes + leftZeros + rightZeros
            );

            leftZeros = rightZeros;
        }

        return ans;
    }
}