package cracking.chapter4

/**
  * 4.1 Implement a function to check if a binary tree is balanced. For the purposes of
  * this question, a balanced tree is defined to be a tree such that the heights of the
  * two subtrees of any node never differ by more than one.
  */
object IsBalanced_4_1 {


  case class TreeNode[T](data: T, left: Option[TreeNode[T]] = None, right: Option[TreeNode[T]] = None)


  def isBalanced[T](node: TreeNode[T]): Boolean = {

    def height[T](node: TreeNode[T]): Either[Boolean, Int] = {
      var leftHeight: Either[Boolean, Int] = Right(0)
      var rightHeight: Either[Boolean, Int] = Right(0)
      node match {
        case TreeNode(data, Some(left), None) =>
          val leftHeight = height(left) match {
            case unbalanced@Left(_) => unbalanced
            case Right(height) => Right(height + 1)
          }
        case TreeNode(data, None, Some(right)) =>
          val rightHeight = height(right) match {
            case unbalanced@Left(_) => unbalanced
            case Right(height) => Right(height + 1)
          }
        case TreeNode(data, Some(left), Some(right)) =>
          val leftHeight = height(left) match {
            case unbalanced@Left(_) => unbalanced
            case Right(height) => Right(height + 1)
          }
          val rightHeight = height(right) match {
            case unbalanced@Left(_) => unbalanced
            case Right(height) => Right(height + 1)
          }
        case TreeNode(data, None, None) =>
          leftHeight = Right(0)
          rightHeight = Right(0)
      }

      if (leftHeight.isLeft || rightHeight.isLeft) {
        Left(true)
      } else {
        val height = math.abs(leftHeight.right.get - rightHeight.right.get)
        if (height > 1)
          Left(true)
        else Right(math.max(leftHeight.right.get, rightHeight.right.get))
      }


    }

    val treeHeight = height(node)
    treeHeight.isRight
  }


  def main(args: Array[String]) {


    //    val root = TreeNode(90,
    //      Some(TreeNode(80,
    //        Some(TreeNode(70)),
    //        Some(TreeNode(90)))
    //      ),
    //      Some(TreeNode(110,
    //        Some(TreeNode(100)),
    //        Some(TreeNode(120)))
    //      )
    //    )

    val root = TreeNode(90,
      Some(TreeNode(80,
        Some(TreeNode(70)),
        Some(TreeNode(90)))
      )
    )
    println(isBalanced(root))

  }
}
