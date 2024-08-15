package LeetCode.medium;

/*

153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
15 Aug 2024

*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;
        int s = 0;
        int e = nums.length-1;

        while(s <= e) {

            int mid = (e+s)/2;

            min = Math.min(min, nums[mid]);

            if(nums[mid] < nums[e]) // go left
                e =  mid-1;
            else // go right
                s=  mid+1;
        }

        return min;
    }
}
