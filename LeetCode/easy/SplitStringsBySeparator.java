package LeetCode.easy;

import java.util.LinkedList;
import java.util.List;

// 2788. Split Strings by Separator
// https://leetcode.com/problems/split-strings-by-separator/description/
// Date : 29 July 2024

public class SplitStringsBySeparator {

    public static void main(String[] args) {
        List<String> inp = new LinkedList<String>();
        inp.add("one.two.three");
        inp.add("four.five");
        inp.add("six");

        List<String> s = SplitStringsBySeparator.splitWordsBySeparator(inp,  '.');
        // Output: ["one","two","three","four","five","six"]
        System.out.println(s);
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> returnedList = new LinkedList<String>();

        String sep = "\\" + String.valueOf(separator);

        for(String word : words) {

            String[] str = word.split(sep);

            for(int i=0; i<str.length; i++) {

                String x = str[i].trim();

                if(x.length() > 0)
                    returnedList.add(x);
            }
        }

        return returnedList;

    }
}
