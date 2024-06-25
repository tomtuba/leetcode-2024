/**
 * 49. Group Anagrams
 */
package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> byKey = new HashMap<>();

        for (int x = 0; x < strs.length; x ++) {
            byKey.computeIfAbsent(key(strs[x]), el -> new ArrayList<>()).add(strs[x]);
        }

        return byKey.values().stream().toList();
    }

    String key(String s) {
        char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
