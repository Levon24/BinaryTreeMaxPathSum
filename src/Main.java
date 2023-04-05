/*
На вход дается непустое бинарное дерево.
Найти максимальную сумму пути в этом дереве.
"Путь" в бинарном дереве -- последовательность узлов, связанных отношениями родитель--потомок.
Путь должен содержать как минимум один узел.

Пример 1
Вход:
       1
      / \
     2   3

Выход: 6

Пример 2
Вход:
   -10
   / \
  9  20
    /  \
  15   7
  /   / \
-20  3  1
Output: 42?
*/

public class Main {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static TreeNode m20 = new TreeNode(-20, null, null);
  static TreeNode p15 = new TreeNode(15, m20, null);
  static TreeNode p3 = new TreeNode(3, null, null);
  static TreeNode p1 = new TreeNode(1, null, null);
  static TreeNode p7 = new TreeNode(7, p3, p1);
  static TreeNode p20 = new TreeNode(20, p15, p7);
  static TreeNode p9 = new TreeNode(9, null, null);
  static TreeNode root = new TreeNode(-10, p9, p20);

  public static void main(String[] args) {
    System.out.println("Hello world!");

    System.out.println("Sum: " + maxPathSum(root));
  }

  public static int maxPathSum(TreeNode leaf) {
    if (leaf == null)
      return 0;

    int left = maxPathSum(leaf.left);
    int right = maxPathSum(leaf.right);
    System.out.println("val: " + leaf.val + ", left: " + left + ", right: " + right);

    int first = Math.max(0, Math.max(left, right) + leaf.val);
    System.out.println("first: " + first);

    int second = Math.max(first, left + right + leaf.val);
    System.out.println("second: " + second);

    return Math.max(first, second);
  }
}
