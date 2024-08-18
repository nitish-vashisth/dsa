package LeetCode.medium;


// 62. Unique Paths

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[] prev = new int[n];
        int[] curr = new int[n];
        curr[0] = 1;
        int max = 0;

        for(int i=0; i<n; i++)
            prev[i] = 1;



        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                curr[j] = curr[j-1] + prev[j];
            }
            prev = curr;
            curr[0] = 1;
        }


        return prev[n-1];
    }
}
