package array;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(nums1[2]);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int x = m-1, y = n-1, i = m+n-1;
        while (x >= 0 && y >= 0) {
            if (nums1[x] >= nums2[y]) {
                nums1[i--] = nums1[x--];
            } else {
                nums1[i--] = nums2[y--];
            }
        }
        while (y >= 0) {
            nums1[i--] = nums2[y--];
        }
    }
}
