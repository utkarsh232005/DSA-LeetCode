class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map dict = new HashMap<>();
        for (List entry : knowledge) {
            dict.put(entry.get(0), entry.get(1));
        }

        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                inBracket = true;
            } else if (c == ')') {
                inBracket = false;
                res.append(dict.getOrDefault(key.toString(), "?"));
                key.setLength(0); 
            } else {
                if (inBracket) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}