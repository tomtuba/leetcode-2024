/**
 * 3. Longest Substring Without Repeating Characters
 */
package solutions;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int[] counts = new int[256];
        char[] arr = s.toCharArray();

        int max = 0;

        int low = 0;
        int high = 0;
        counts[arr[high]]++;

        while (high < s.length() && low < s.length()) {
            if (hasMultiples(counts)) {
                counts[arr[low++]]--;
            } else {
                max = Math.max(max, 1 + high-low);
                if (++high < s.length()) {
                    counts[arr[high]]++;
                }
            }
        }

        return max;
    }

    boolean hasMultiples(int[] arr) {
        for (int x = 0; x < arr.length; x ++) {
            if (arr[x] > 1) return true;
        }
        return false;
    }
}
