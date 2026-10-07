class Solution {
    public void sortColors(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (mid <= r) {
            if (arr[mid] == 0) {
                swap(arr, mid, l);
                l++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, r);
                r--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}