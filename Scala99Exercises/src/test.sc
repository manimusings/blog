import scala.collection.mutable.ListBuffer


val list = List(List('b, 'c), List('c, 'b))
val listHead = list.head
//var listOfList = list.map(List(_))

var index = 1
var (split, remaining) = listHead.splitAt(index)
var splitGroup = List(List.empty[Symbol])
while (remaining.nonEmpty) {
  splitGroup = (('a :: split) ++ remaining) :: splitGroup
  index = index + 1
  (split, remaining) = listHead.splitAt(index)
}
splitGroup






















