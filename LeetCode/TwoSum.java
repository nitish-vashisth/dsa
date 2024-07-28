package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class TwoSum {

    public static void main(String[] args) {

        int[] inp = {3, 3};

        TwoSum  twoSum = new TwoSum();
        int[] ret = twoSum.twoSum(inp, 6);
        System.out.println(ret[0] + " " + ret[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[2];

        HashMap<Integer, LinkedList<Integer>> hs = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            LinkedList<Integer> al = null;
            if(hs.containsKey(nums[i]))
                al = hs.get(nums[i]);
            else
                al = new LinkedList<Integer>();

            al.add(i);
            hs.put(nums[i], al);
        }

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int y = target  - num;

            if(hs.containsKey(y)){
                LinkedList<Integer> al = hs.get(y);
                ret[1] = al.remove();

                if(num==y) {
                    ret[0] = al.remove();
                } else {
                    ret[0] = i;
                }
                break;
            }
        }

        return ret;
    }
}
