class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        char[] chars = new char[num];
        Arrays.fill(chars, '0');
        int nines = sum / 9;
        int rem = sum % 9;
        Arrays.fill(chars, 0, nines, '9');
        if (rem > 0) {
            chars[nines] = (char) ('0' + rem);
        }
        return new String(chars);
    }
}