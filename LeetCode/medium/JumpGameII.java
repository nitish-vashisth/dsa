package LeetCode.medium;

/*

45. Jump Game II

6 Aug 2024

https://leetcode.com/problems/jump-game-ii/description/

*/

public class JumpGameII {

    public int jump(int[] nums) {

        int len = nums.length;

        if(len == 1)
            return 0;

        int currPos = 0;
        int nextPos = 0;
        int minJump = 0;



        while(currPos< len) {

            if( (currPos + nums[currPos]) >= len-1) {
                minJump++;
                return minJump;
            }

            int k = currPos + 1;
            nextPos = k; //

            k = k + 1;

            while( (k <=  (nums[currPos] + currPos) && k < len) ){
                if(nums[k]!=0) {
                    int nextMaxPos = nums[k] + k;

                    int y = nums[nextPos] + nextPos;

                    if(nextMaxPos >= y)
                        nextPos = k;
                }
                k++;
            }

            currPos = nextPos;
            minJump++;
        }

        return minJump;
    }
}
