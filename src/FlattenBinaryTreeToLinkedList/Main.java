package FlattenBinaryTreeToLinkedList;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //Input: root = [1,2,5,3,4,null,6]
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(5);
        test.left.left = new TreeNode(3);
        test.left.right = new TreeNode(4);
        test.right.right = new TreeNode(6);
        flatten(test);
        System.out.println(test.toString());

    }

    // time complexly supposed to be: O(n)

    // no stack solution:
    public static void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
            TreeNode tempNode = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode currNode = root.right;
            while (currNode.right != null) {
                currNode = currNode.right;
            }
            currNode.right = tempNode;
        }
        flatten(root.right);
    }

}
























