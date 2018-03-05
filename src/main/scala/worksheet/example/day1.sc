
def map(xs: List[Int], f: Int => Int): List[Int] = {
 var newList = List.empty
  xs.foreach(x => {
   newList :+ f(x)
 })
  newList
}


map(List(1,2,3), x => x * x)


//def mapRec(xs: List[Int], f: Int => Int): List[Int] = {
// xs match {
//   case xs.head :: xs.tail => f(xs.head) :: mapRec(xs.tail, f)
//   case xs if xs.isEmpty => _
// }
//}

//mapRec(List(1,2,3), x => x * x)

def map3(xs: List[Int], f: Int => Int): List[Int] = {

  def loop(rem: List[Int], acc: List[Int]): List[Int] = {
    if(xs.isEmpty) acc
    else loop(rem.tail, f(rem.head) :: acc)
  }

  loop(xs, List.empty).reverse
}

def reverseRec(xs: List[Int]): List[Int] = {
  def reverse(rem: List[Int], acc: List[Int]): List[Int] = {
    if (rem.isEmpty) acc
    else reverse(rem.tail, acc.head :: acc)
  }
  reverse(xs, List.empty)
}
