package LeetCode.medium;

public class SearchInRotatedSortedArray {

    // 33. Search in Rotated Sorted Array
    // 2 Aug 2024
    // Adobe

    public int search(int[] nums, int target) {

        return findNum(0, nums.length-1, nums, target);

    }

    public int findNum (int l, int h, int[] nums, int target) {

        if(h < l)
            return -1;

        int m = (h+l)/2;

        int mid = nums[m];

        if(mid==target)
            return m;

        int low = nums[l];
        int high = nums[h];

        if( (low <= mid) ) { // sorted {
            if (target >= low && target <= mid) // left
                return findNum(l, m-1, nums, target);
            else // Right
                return findNum(m+1, nums.length-1, nums, target);
        } else {
            if(target >= low || target <= mid) // go left
                return findNum(l, m-1, nums, target);
            else // right
                return findNum(m+1, nums.length-1, nums, target);
        }
    }
}
