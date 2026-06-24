class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (String op : operations) {
            if(op.equals("C")){
                ans.remove(ans.size()-1);
            }else if(op.equals("D")){
                int a = 2 * ans.get(ans.size()-1);
                ans.add(a);
            }else if(op.equals("+")){
                int a = ans.get(ans.size()-1);
                int b = ans.get(ans.size()-2);
                int c = a+b;
                ans.add(c);
            }else {
                ans.add(Integer.parseInt(op));
            }
        }
        
        int result = 0;
        for (int score : ans) {
            result += score;
        }
        return result;
    }
}