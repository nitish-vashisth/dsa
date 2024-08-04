package LeetCode.easy;

/*
26. Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
4 Aug 2024
*/

public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        int i=0;
        int k = 1;
        int j=1;

        while(j < len) {

            if(nums[j]==nums[i]){
                j++;
                continue;
            }

            i = i+1;
            k++;
            nums[i] = nums[j];
            j++;
        }

        return k;
    }

}
