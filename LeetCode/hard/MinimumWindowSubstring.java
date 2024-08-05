package LeetCode.hard;

import java.util.*;

/*

76. Minimum Window Substring

https://leetcode.com/problems/minimum-window-substring/description/

Date : 5 Aug 2024

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

*/

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));

    }

    public String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();

        if(m<n)
            return "";

        HashMap<Character, CharCount> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            char ch = t.charAt(i);
            if(map.containsKey(ch)) {
                CharCount node = map.get(ch);
                node.tC++;
            } else {
                map.put(ch, new CharCount(0, 1));
            }
        }

        int k = 0;

        int i=0, j=0;
        int si=0, ei=0;
        int minSize = Integer.MAX_VALUE;

        while(j<m) {

            if(k==map.size()){

                char chI = s.charAt(i);

                int currSize= j-i+1;
                if(currSize < minSize){
                    minSize = currSize;
                    si = i; ei = j;
                }

                if(map.containsKey(chI)) {
                    CharCount node = map.get(chI);
                    node.sC--;
                    if(node.sC < node.tC){
                        k--;
                    }
                }
                i++;
                continue;
            }

            char ch = s.charAt(j);

            if(map.containsKey(ch)) {
                CharCount node = map.get(ch);
                node.sC++;
                if(node.sC == node.tC)
                    k++;
            }

            j++;
        }

        while(i < m) {
            if(k==map.size()){

                char chI = s.charAt(i);

                int currSize= j-i+1;
                if(currSize < minSize){
                    minSize = currSize;
                    si = i; ei = j;
                }

                if(map.containsKey(chI)) {
                    CharCount node = map.get(chI);
                    node.sC--;
                    if(node.sC < node.tC){
                        k--;
                    }
                }
                i++;
                continue;
            } else {
                break;
            }
        }




        return s.substring(si, ei);
    }

    class CharCount{
        public int sC;
        public int tC;

        public CharCount(int sC, int tC) {
            this.sC = sC;
            this.tC = tC;
        }
    }

}
