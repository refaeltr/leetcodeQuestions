package FlattenBinaryTreeToLinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val + '\n' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void preOrder() {
        preOrder(this);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.val);
        preOrder(node.left);
        preOrder(node.right);
    }


}
