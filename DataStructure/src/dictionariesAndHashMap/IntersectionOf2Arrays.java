package dictionariesAndHashMap;

import java.util.Arrays;

public class IntersectionOf2Arrays {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int x=0, y=0, i = 0;
        while (x < m && y < n) {
            if (nums1[x] < nums2[y])
                x++;
            else if (nums2[y] < nums1[x])
                y++;
            else {
                nums1[i++] = nums1[x++];
                y++;
            }
        }
        return Arrays.copyOf(nums1, i);
    }
}
