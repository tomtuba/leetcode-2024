/**
 * 138. Copy List with Random Pointer
 */ 
package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import solutions.common.Node;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> oldIndexes = new HashMap<>();
        List<Node> newList = new ArrayList<>();

        Node node = head;

        while (node != null) {
            oldIndexes.put(node, newList.size());
            newList.add(new Node(node.val));
            node = node.next;
        }

        Node result = newList.get(0);
        
        node = head;

        for (int x = 0; x < newList.size(); x ++) {
            Node newNode = newList.get(x);
            newNode.next = Optional.ofNullable(node.next).map(oldIndexes::get)
                .map(newList::get).orElse(null);
            newNode.random = Optional.ofNullable(node.random).map(oldIndexes::get)
                .map(newList::get).orElse(null);
            node = node.next;
        }
        return result;
    }
}
