class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        int[] inStack = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (inStack[idx] == 1) {
                continue;
            }
            while (st.length() > 0) {
                char top = st.charAt(st.length() - 1);
                if (top > ch && last[top - 'a'] > i) {
                    inStack[top - 'a'] = 0;
                    st.deleteCharAt(st.length() - 1);
                } else {
                    break;
                }
            }
            st.append(ch);
            inStack[idx] = 1;
        }

        return st.toString();
    }
}