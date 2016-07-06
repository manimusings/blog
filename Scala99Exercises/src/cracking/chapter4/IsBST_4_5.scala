package cracking.chapter4

/**
  * 4.5 Implement a function to check if a binary tree is a binary search tree.
  */
object IsBST_4_5 {


  case class TreeNode[T](data: T, left: Option[TreeNode[T]] = None, right: Option[TreeNode[T]] = None)


  def isBST(node: TreeNode[Int]): Boolean = {

    (!node.left.isDefined || (node.left.get.data <= node.data && isBST(node.left.get))) &&
      (!node.right.isDefined || (node.right.get.data > node.data && isBST(node.right.get)))

  }


  def main(args: Array[String]) {
    val root = TreeNode(90,
      Some(TreeNode(80,
        Some(TreeNode(70)),
        Some(TreeNode(90)))
      ),
      Some(TreeNode(110,
        Some(TreeNode(100)),
        Some(TreeNode(120)))
      )
    )

    println(isBST(root))

  }
}
