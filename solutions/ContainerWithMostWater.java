/**
 * 11. Container With Most Water
 */
package solutions;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        List<Integer> highest = new ArrayList<>();

        int max = 0;

        for (int x = 0; x < height.length; x ++) {
            for (int y = 0; y < highest.size(); y ++) {
                int bigIndex = highest.get(y);
                max = Math.max(max, Math.min(height[x],height[bigIndex]) * (x - bigIndex));
            }
            if (highest.size() == 0 || height[x] > height[highest.get(highest.size()-1)]) {
                highest.add(x);
            }
        }
        return max;
    }
}
