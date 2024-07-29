package LeetCode.medium;



/*
* 347. Top K Frequent Elements
* https://leetcode.com/problems/top-k-frequent-elements/description/
*
* Date : 29/07/2024
*
* Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
*
* */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    class Node {

        int num;
        int count;

        public Node (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] ret = new int[k];

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            int x = nums[i];
            if(!hm.containsKey(x)){
                hm.put(x, 1);
            } else {
                int c = hm.get(x);
                hm.put(x, c+1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) ->  b.count - a.count);

        for(Map.Entry<Integer, Integer> x : hm.entrySet()) {

            int num = x.getKey();
            int count = x.getValue();

            pq.add(new Node(num, count));
        }

        int i=0;
        while(i < k) {
            Node x = pq.remove();
            ret[i] = x.num;
            i++;
        }

        return ret;
    }

}
