package LeetCode.medium;

// 5. Longest Palindromic Substring

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int max = 0;
        int[] coor = new int[2];
        int si = 0;
        int ei = 0;

        for(int i=0; i<s.length(); i++){
            coor[0] = i;
            coor[1] = i;
            palindrom(i, i, s, coor);

            if((coor[1] - coor[0] + 1)>max){
                si = coor[0];
                ei = coor[1];
                max = ei-si+1;
            }

            if( (i!= s.length()-1) && (s.charAt(i)==s.charAt(i+1)) ){
                coor[0] = i;
                coor[1] = i+1;

                palindrom(i, i+1, s, coor);

                if((coor[1] - coor[0] + 1)>max){
                    si = coor[0];
                    ei = coor[1];
                    max = ei-si+1;
                }
            }
        }

        return s.substring(si, ei+1);
    }

    public void palindrom(int s, int e, String ss, int[] coor ) {


        while( (s>=0 && e < ss.length())) {

            if(ss.charAt(s)==ss.charAt(e)) {
                coor[0] = s;
                coor[1] = e;
                s--; e++;
                continue;
            }
            break;
        }
    }
}
