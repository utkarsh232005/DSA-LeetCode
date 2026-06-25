import java.util.*;

class Solution {
    public String reverseStr(String s, int k) {
        int l =0;
        int r=Math.min(k,s.length());
        char[] arr = s.toCharArray();
        while(l<s.length()){
            reverse(arr,l,r);
            l=l+2*k;
            r=Math.min(l+k,s.length());
        }
        return new String(arr);
    }
    private void reverse(char[] arr,int st,int end){
        while(st<end){
            char temp = arr[end-1];
            arr[end-1] = arr[st];
            arr[st] = temp;
            end--;
            st++;
        }
    }
}