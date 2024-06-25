/**
 * 94. Binary Tree Inorder Traversal
 */
package solutions;

import java.util.List;
import java.util.ArrayList;

import solutions.common.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        explore(root, answer);

        return answer;
    }

    void explore(TreeNode node, List<Integer> answer) {
        if (node != null) {
            explore(node.left, answer);
            answer.add(node.val);
            explore(node.right, answer);
        }
    }
}