class Solution {
    public int maxProduct(int n) {
        int temp = 0;
        int max = 0;
        int[] digits = Integer.toString(Math.abs(n)).chars().map(Character::getNumericValue).toArray();
        Arrays.sort(digits);
        for(int i=0;i<digits.length-1;i++){
            int prod = digits[i] * digits[i+1];
            max = Math.max(prod,max);
        }
        return max;
    }
}