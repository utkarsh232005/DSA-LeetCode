class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        
        // Track missing character types
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = 1;
            else if (Character.isUpperCase(c)) hasUpper = 1;
            else if (Character.isDigit(c)) hasDigit = 1;
        }
        int missingTypes = 3 - (hasLower + hasUpper + hasDigit);

        // Case 1: Length < 6
        // Insertions can simultaneously resolve missing types and break up repeats.
        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        }

        // Count repeating runs and their lengths
        int replace = 0;
        int oneMod = 0, twoMod = 0;
        
        for (int i = 2; i < n; i++) {
            if (password.charAt(i) == password.charAt(i - 1) && 
                password.charAt(i) == password.charAt(i - 2)) {
                int len = 2;
                while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                    len++;
                    i++;
                }
                replace += len / 3;
                if (len % 3 == 0) oneMod++;
                else if (len % 3 == 1) twoMod++;
            }
        }
        if (n <= 20) {
            return Math.max(replace, missingTypes);
        }
        int deleteCount = n - 20;
        int d1 = Math.min(deleteCount, oneMod);
        replace -= d1;
        deleteCount -= d1;
        int d2 = Math.min(deleteCount / 2, twoMod);
        replace -= d2;
        deleteCount -= d2 * 2;
        int d3 = deleteCount / 3;
        replace -= d3;

        return (n - 20) + Math.max(Math.max(replace, 0), missingTypes);
    }
}