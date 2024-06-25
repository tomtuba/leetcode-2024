package solutions;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
        public int findDuplicate(int[] nums) {
        Set<Integer> found = new HashSet<>();
        for (int x = 0; x < nums.length; x ++) {
            if (! found.add(nums[x])) return nums[x];
        }
        return -1;
    }
}
