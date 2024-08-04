package LeetCode.medium;

import java.util.*;

/*

15. 3Sum
https://leetcode.com/problems/3sum/description/

Note - Check solutions by other. As code is verbose
Also, could this solution be extended for 4 Sum, 5 Sum
*/

public class iiiSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<String> solSet = new HashSet<>();
        List<List<Integer>> solution = new LinkedList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> nums2 = new ArrayList<>();
        int t=0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) {
                if(map.get(nums[i]).size()<3){
                    map.get(nums[i]).add(t); t++;
                    nums2.add(nums[i]);
                }
            } else {
                List<Integer> indexList = new LinkedList<Integer>();
                indexList.add(t); t++;
                map.put(nums[i], indexList);
                nums2.add(nums[i]);
            }
        }


        for(int i=0; i<nums2.size(); i++ ) {
            for(int j=i+1; j<nums2.size(); j++) {
                int x = nums2.get(i) + nums2.get(j);

                if(map.containsKey(0-x)) {
                    List<Integer> indexList = map.get(0-x);
                    for(Integer k : indexList) {

                        if( (i==k) || (j==k))
                            continue;

                        String s = "";
                        int ai = nums2.get(i); int aj = nums2.get(j);  int ak = nums2.get(k);

                        if( (ai <= aj) && (ai <= ak)) {
                            s = ai + "-" + Math.min(aj, ak) + "-" + Math.max(aj,ak);
                        }
                        else if( (aj <= ai) && (aj <= ak)) {
                            s = aj + "-" + Math.min(ai, ak) + "-" + Math.max(ai,ak);
                        }
                        else {
                            s = ak + "-" + Math.min(ai, aj) + "-" + Math.max(ai,aj);
                        }

                        if(!solSet.contains(s)) {
                            solSet.add(s);
                            LinkedList<Integer> ll = new LinkedList<>();
                            ll.add(nums2.get(i)); ll.add(nums2.get(j)); ll.add(nums2.get(k));
                            solution.add(ll);
                        }
                    }
                }
            }
        }

        return solution;
    }
}
