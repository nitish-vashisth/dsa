package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    /*
    * 767. Reorganize String
    * https://leetcode.com/problems/reorganize-string/description/
    * Date : 25/07/2024
    * */

    class Node {

        public char c;
        public int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }

    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();

        System.out.println(reorganizeString.reorganizeString("aaab"));
    }

    public String reorganizeString(String s) {

        int len = s.length();
        int maxCount = 0;

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i=0; i<len; i++) {
            int c = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), c+1);
            if( (c+1) > maxCount)
                maxCount = c+1;
        }

        int k = len % 2 == 0 ? len/2 : (len/2) + 1;

        if(maxCount > k)
            return "";

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> {
            if(a.count == b.count)
                return (int)a.c - (int)b.c;
            return b.count - a.count;
        });

        for(Map.Entry<Character, Integer> x : hm.entrySet()) {
            char c = x.getKey();
            int count = x.getValue();
            pq.add(new Node(c, count));
        }

        StringBuilder br = new StringBuilder();
        while(pq.size() >= 2) {

            Node a = pq.remove();
            Node b = pq.remove();

            br.append(String.valueOf(a.c));
            br.append(String.valueOf(b.c));

            a.count = a.count - 1;
            b.count = b.count - 1;

            if(a.count != 0)
                pq.add(a);

            if(b.count != 0)
                pq.add(b);
        }

        if(pq.size() > 0) {
            Node a = pq.remove();
            br.append(String.valueOf(a.c));
        }

        return br.toString();
    }

}
