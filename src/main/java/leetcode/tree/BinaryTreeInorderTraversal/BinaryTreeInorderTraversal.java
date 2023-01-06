package leetcode.tree.BinaryTreeInorderTraversal;

import java.util.*;
import java.util.concurrent.BlockingDeque;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);

        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n7, n9);

        TreeNode n5 = new TreeNode(5);

        TreeNode n6 = new TreeNode(6, n5, n8);

        TreeNode root = new TreeNode(4, n2, n6);

        List<Integer> tr = new BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println(tr);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> traversal = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.getLast();

            TreeNode left = node.left;
            if (left != null) {
                deque.addLast(left);
                node.left = null;
                continue;
            }

            if (node.val != Integer.MIN_VALUE) {
                traversal.add(node.val);
                node.val = Integer.MIN_VALUE;
            }

            TreeNode right = node.right;
            if (right != null) {
                deque.addLast(right);
                node.right = null;
                continue;
            }

            deque.pollLast();
        }

        return traversal;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

