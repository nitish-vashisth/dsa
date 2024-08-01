package LeetCode.medium;

/*
Question : 264. Ugly Number II
Link : https://leetcode.com/problems/ugly-number-ii/description/
Date : 1 Aug 2-24
*/

public class UglyNumberII {

    public static void main(String[] args) {

        System.out.println(UglyNumberII.nthUglyNumber(10)); // 12

    }

    public static int nthUglyNumber(int n) {

        int[] uN  = new int[n];
        uN[0] = 1;
        int nextUgly = 1;

        int i=1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        while(i < n) {

            int x2 = uN[i2] * 2;
            int x3 = uN[i3] * 3;
            int x5 = uN[i5] * 5;

            int num = Math.min(x2, Math.min(x3, x5));

            if(uN[i-1] != num){
                uN[i] = num;
                i++;
            }

            if(num == x2)
                i2++;
            if(num == x3)
                i3++;
            if(num == x5)
                i5++;
        }

        return uN[n-1];

    }

}
