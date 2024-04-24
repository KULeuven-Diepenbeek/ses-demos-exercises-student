package exercises.ex18_tree;

import java.util.function.Consumer;

public class Tree {

    public static <T> TreeNode<T> mirror(TreeNode<T> tree) {
        if (tree == null) return null;
        return new TreeNode<>(tree.value(), mirror(tree.right()), mirror(tree.left()));
    }

    public static int treeSize(TreeNode<?> tree) {
        if (tree == null) return 0;
        return 1 + treeSize(tree.left()) + treeSize(tree.right());
    }

    public static int treeHeight(TreeNode<?> tree) {
        if (tree == null) return 0;
        var heightL = 0;
        var heightR = 0;
        if (tree.left() != null) {
            heightL = 1 + treeHeight(tree.left());
        }
        if (tree.right() != null) {
            heightR = 1 + treeHeight(tree.right());
        }
        return Math.max(heightL, heightR);
    }




    public static <T> void visitDepthFirstPreOrder(TreeNode<T> tree, Consumer<T> consumer) {
        if (tree == null) return;
        consumer.accept(tree.value());
        visitDepthFirstPreOrder(tree.left(), consumer);
        visitDepthFirstPreOrder(tree.right(), consumer);
    }







    public static <T> void visitDepthFirstInOrder(TreeNode<T> tree, Consumer<T> consumer) {
        if (tree == null) return;
        visitDepthFirstInOrder(tree.left(), consumer);
        consumer.accept(tree.value());
        visitDepthFirstInOrder(tree.right(), consumer);
    }

}
