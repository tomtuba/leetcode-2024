/**
 * 15. 3Sum
 */
package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();

        for (int x = 0; x < nums.length - 2; x ++) {

            if (x == 0 || nums[x] != nums[x-1]) {
                int low = x + 1;
                int high = nums.length-1;

                while (low < high) {
                    int sum = nums[x] + nums[low] + nums[high];
                    if (sum == 0) {
                        answer.add(List.of(nums[x],nums[low++],nums[high--]));
                        while (low < high && nums[low] == nums[low-1]) low ++;
                        while (low < high && nums[high] == nums[high+1]) high --;
                    } else {
                        if (sum < 0) low ++;
                        else high --;
                    }
                }
            }
            
        }

        return answer;
    }
}
