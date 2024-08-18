package LeetCode.medium;

import java.util.HashSet;

//3. Longest Substring Without Repeating Characters

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hs = new HashSet<>();
        int y = 0;
        int max = 0;

        for(int i=0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if(!hs.contains(curr)) {
                hs.add(curr);
                max = Math.max(max, i-y+1);
            } else {
                while(true) {
                    char prev = s.charAt(y);
                    if(prev == curr){
                        y++;
                        break;
                    }
                    hs.remove(prev);
                    y++;
                }
            }

        }

        return max;
    }

}
