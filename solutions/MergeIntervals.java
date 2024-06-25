/**
 * 56. Merge Intervals
 */
package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] last = intervals[0];
        merged.add(last);

        for (int x = 1; x < intervals.length; x ++) {
            if (last[1] >= intervals[x][0]) {
                last[1] = Math.max(last[1],intervals[x][1]);
            } else {
                last = intervals[x];
                merged.add(last);
            }
        }

        int[][] answer = new int[merged.size()][];

        for (int x = 0; x < merged.size(); x ++) {
            answer[x] = merged.get(x);
        }
        return answer;
    }
}
