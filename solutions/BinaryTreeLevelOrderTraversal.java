/**
 * 102. Binary Tree Level Order Traversal
 */
package solutions;

import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

import solutions.common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        if (root != null) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();

            queue.add(root);

            while (queue.size() > 0) {
                List<Integer> row = new ArrayList<>();
                answer.add(row);
                int levelSize = queue.size();
                while (levelSize-- > 0) {
                    TreeNode node = queue.pollFirst();
                    row.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return answer;
    }
}