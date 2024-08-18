package LeetCode.medium;

//11. Container With Most Water

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxWater = 0;

        int i=0;

        int j=height.length-1;

        while(i < j) {

            int x = height[i];
            int y = height[j];

            int water = (j-i) * Math.min(x,y);
            maxWater = Math.max(maxWater, water);

            if(x <= y)
                i++;
            else
                j--;
        }

        return maxWater;
    }

}
