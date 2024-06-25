/**
 * 347. Top K Frequent Elements
 */
package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, ElementCounter> collatedResults = new HashMap<>();

        for (int x = 0; x < nums.length; x ++) {
            collatedResults
            .computeIfAbsent(nums[x], ElementCounter::new).tally ++;
        }

        List<ElementCounter> finished = new ArrayList<>();
        finished.addAll(collatedResults.values());
        Collections.sort(finished);
        int[] answer = new int[k];

        for (int x = 0; x < k; x ++) {
            answer[x] = finished.get(x).element;
        }
        return answer;
    }

    static class ElementCounter implements Comparable<ElementCounter> {
        int element;
        int tally;

        ElementCounter(int element) {
            this.element = element;
        }

        public int compareTo(ElementCounter other) {
            return other.tally - this.tally;
        }
    }
}
