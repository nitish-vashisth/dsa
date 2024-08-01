package LeetCode.medium;

public class JumpGame {

    /*
    * 55. Jump Game
    * https://leetcode.com/problems/jump-game/description/
    * 1 August 2024
    *
        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Example 2:

        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what.
        Its maximum jump length is 0, which makes it impossible to reach the last index.
    * */

    public boolean canJump(int[] nums) {

        int currPos=0;
        int len = nums.length;


        while(currPos < nums.length) {

            if(currPos >= (len-1))
                return true;

            int currVal = nums[currPos];

            if(currVal==0)
                return false;

            int i= 1 + currPos;
            int j = currVal + currPos;


            int nextPos = currPos + 1;
            int max = nums[nextPos] + nextPos;

            while (i <= j) {

                if(i >= len)
                    break;

                int maxReach = nums[i] + i;
                if(maxReach >= max) {
                    max = maxReach;
                    nextPos = i;
                }

                i++;
            }
            currPos = nextPos;
        }

        if(currPos >= len)
            return true;

        return false;
    }

}
