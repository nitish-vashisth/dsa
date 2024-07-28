package LeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] inp = {100,4,200,1,3,2};
        // out : [1, 2, 3, 4]
        System.out.println("LCS : " + longestConsecutive(inp));

        int[] inp2 = {0,3,7,2,5,8,4,6,0,1};
        // out : 9
        System.out.println("LCS : " + longestConsecutive(inp2));
    }

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> hs  = new HashSet<Integer>();

        for(int i=0; i<nums.length; i++)
            hs.add(nums[i]);

        int max = 0;

        for(int i=0; i<nums.length; i++) {

            int x = nums[i];

            if(hs.contains(x)) {

                int len = 1;
                hs.remove(x);

                int a = x+1;
                int c = 0;
                // for increasing
                while(true) {
                    if(hs.contains(a)) {
                        c++;
                        hs.remove(a);
                        a = a+1;
                    } else {
                        break;
                    }
                }
                len = len + c;
                c = 0;
                a = x-1;

                // for decreasing
                while(true) {
                    if(hs.contains(a)) {
                        c++;
                        hs.remove(a);
                        a = a-1;
                    } else {
                        break;
                    }
                }
                len = len + c;
                max = Math.max(max, len);

            }

        }

        return max;
    }

}
