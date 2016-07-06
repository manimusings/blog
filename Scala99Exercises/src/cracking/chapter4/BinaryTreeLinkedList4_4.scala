package cracking.chapter4

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object BinaryTreeLinkedList4_4 {

  case class TreeNode[T](data: T, left: Option[TreeNode[T]] = None, right: Option[TreeNode[T]] = None)

  def populateLists[T](root: TreeNode[T]): Seq[Seq[TreeNode[T]]] = {
    def populateLists[T](node: TreeNode[T], lists: ArrayBuffer[ListBuffer[TreeNode[T]]], depth: Int): Unit = {
      if (!lists.isDefinedAt(depth)) {
        lists += ListBuffer[TreeNode[T]]()
      }
      lists(depth) += node
      node.left.foreach(populateLists(_, lists, depth + 1))
      node.right.foreach(populateLists(_, lists, depth + 1))
    }
    val result = ArrayBuffer[ListBuffer[TreeNode[T]]]()
    populateLists(root, result, 0)
    result
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
    println(populateLists(root))


  }
}
