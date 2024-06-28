/**
 * 222. Count Complete Tree Nodes
 */
package solutions;

import solutions.common.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = countLeft(root);

        if (leftDepth == countRight(root)) {
            return (1 << leftDepth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int countLeft(TreeNode node) {
        int tally = 0;

        while (node != null) {
            node = node.left;
            tally ++;
        }
        return tally;
    }

    int countRight(TreeNode node) {
        int tally = 0;

        while (node != null) {
            node = node.right;
            tally ++;
        }
        return tally;
    }
}
