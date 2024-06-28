/**
 * 2285. Maximum Total Importance of Roads
 */
package solutions;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int [] values = new int[n];

        for (int x = 0; x < roads.length; x ++) {
            values[roads[x][0]]++;
            values[roads[x][1]]++;
        }

        Arrays.sort(values);

        long total = 0;

        for (int x = 0; x < values.length; x ++) {
            total += (x+1L) * values[x];
        }

        return total;
    }
}
