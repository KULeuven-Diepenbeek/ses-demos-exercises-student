package exercises.ex18_tree;

public record TreeNode<T>(T value, TreeNode<T> left, TreeNode<T> right) {
}
