public class SubarraySumsDivisiblebyK {

    /*
    * 974. Subarray Sums Divisible by K
    * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
    * Date : 25/07/2024
    *
    * Prefix Sum
    * Maths
    *
    * */

    public int subarraysDivByK(int[] nums, int k) {

        int len = nums.length;

        int[] sum = new int[len];

        int count = 0;

        for(int i=0; i<len; i++) {
            if(i==0)
                sum[i] = nums[i];
            else
                sum[i] = sum[i-1] + nums[i];

            if(sum[i] % k==0)
                count++;
        }


        for(int i=1; i<len; i++) {
            for(int j=i; j<len;j++) {
                int x = sum[j] - sum[i-1];
                if(x % k == 0)
                    count++;
            }
        }

        return count;
    }

}
