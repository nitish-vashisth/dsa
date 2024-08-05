package LeetCode.medium;

import java.util.LinkedList;

/*
    56. Merge Intervals
    https://leetcode.com/problems/merge-intervals/description/?source=submission-ac
    03 Aug 2024
*/
public class MergeIntervals {

    class Coordinate {
        int s;
        int e;

        public Coordinate(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int[][] merge(int[][] intervals) {

        LinkedList<Coordinate> al = new LinkedList<>();

        for(int i=0; i<intervals.length; i++) {
            Coordinate coordinate = new Coordinate(intervals[i][0], intervals[i][1]);
            al.add(coordinate);
        }

        al.sort((Coordinate a, Coordinate b)-> {
            return a.s - b.s;
        });

        LinkedList<Coordinate> resultList = new LinkedList<>();

        while(al.size() >= 2) {

            Coordinate x = al.removeFirst();
            Coordinate y = al.removeFirst();

            // Case 2 : e1 >= e2 : Overlap case
            if(x.e >=y.e)    {
                al.addFirst(x);
                continue;
            }


            // Case 1 : e1 < e2
            // Case 1 - 1 : e1=s2
            if(x.e>=y.s) {
                al.addFirst(new Coordinate(x.s, y.e));
                continue;
            }

            // Case 1 - 2 : e1 < s2
            if(x.e < y.s){
                resultList.add(x);
                al.addFirst(y);
            }
        }

        resultList.addAll(al);

        int t = resultList.size();

        int[][] result = new int[t][2];

        for(int i=0; i<t ; i++){
            Coordinate coordinate = resultList.removeFirst();
            result[i][0] = coordinate.s;
            result[i][1] = coordinate.e;
        }

        return result;
    }

}
