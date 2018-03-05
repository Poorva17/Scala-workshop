import worksheet.example.Ord

object Sorter {
  def insert[T](xs: List[T], x: T)(ord: Ord[T]): List[T] = {
    xs match {
      case Nil => x :: xs
      case head :: tail =>
        if (ord.lt(x , head)) x :: xs
        else head :: insert(tail, x)(ord)
    }
  }

  def sort[T](xs: List[T])(ord: Ord[T]): List[T] = {
    xs match {
      case Nil => xs
      case head :: tail => insert(sort(tail)(ord), head)(ord)
    }
  }
}

Sorter.sort(List(2,4,1))(Ord.intOrd)

Sorter.sort(List(Some(2), None, Some(1)))(Ord.optionOrd(Ord.intOrd))

Sorter.sort(List(Some("s"), None, Some("a")))(Ord.optionOrd(Ord.stringOrd))

Sorter.sort(List(Some("s"), None, Some("a")))(Ord.optionOrd(Ord.stringOrd))