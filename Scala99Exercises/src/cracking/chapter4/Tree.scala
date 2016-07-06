package cracking.chapter4

import scala.collection.mutable

object Tree {


  case class TreeNode[T](data: T, left: Option[TreeNode[T]] = None, right: Option[TreeNode[T]] = None)

  sealed trait TraversalOrder

  case object inOrder extends TraversalOrder

  case object preOrder extends TraversalOrder

  case object postOrder extends TraversalOrder

  def bfs[T](node: TreeNode[T], value: T): Boolean = {
    def bfs[T](queue: mutable.Queue[TreeNode[T]], value: T): Boolean = {
      if (queue.isEmpty) false
      else {
        val treeNode = queue.dequeue()
        println(treeNode)
        if (treeNode.data == value) true
        else {
          treeNode.left.foreach(queue.enqueue(_))
          treeNode.right.foreach(queue.enqueue(_))
          bfs(queue, value)
        }
      }
    }
    bfs(mutable.Queue[TreeNode[T]](node), value)
  }

  def dfs[T](node: TreeNode[T], value: T, order: TraversalOrder): Boolean = {
    println(node)
    var check = false
    order match {
      case `preOrder` =>
        check = (node.data == value)
        if (!check) {
          check = node.left.map(dfs(_, value, order)).getOrElse(false)
        }
        if (!check) {
          check = node.right.map(dfs(_, value, order)).getOrElse(false)
        }
        check
      case `inOrder` =>
        check = node.left.map(dfs(_, value, order)).getOrElse(false)
        if (!check) {
          check = (node.data == value)
        }
        if (!check) {
          check = node.right.map(dfs(_, value, order)).getOrElse(false)
        }
        check
      case `postOrder` =>
        check = node.left.map(dfs(_, value, order)).getOrElse(false)
        if (!check) {
          check = node.right.map(dfs(_, value, order)).getOrElse(false)
        }
        if (!check) {
          check = (node.data == value)
        }
        check
    }

  }

  def main(args: Array[String]) {
    val root = TreeNode(1,
      Some(TreeNode(2,
        Some(TreeNode(4)),
        Some(TreeNode(5)))
      ),
      Some(TreeNode(3,
        Some(TreeNode(6)),
        Some(TreeNode(7)))
      )
    )

    println("<BFS>")
    println(bfs(root, 10))
    println("</BFS>")
    println("<DFS>")
    println(dfs(root, 10, inOrder))
    println("</DFS>")
    println("<BFS>")
    println(bfs(root, 5))
    println("</BFS>")
    println("<DFS>")
    println(dfs(root, 5, inOrder))
    println("</DFS>")

  }
}
