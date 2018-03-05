package worksheet.example

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {
  val intOrd: Ord[Int] = new Ord[Int] {
    override def lt(a: Int, b: Int) = a < b
  }

  val stringOrd: Ord[String] = new Ord[String] {
    override def lt(a: String, b: String) = a < b
  }

  def optionOrd[T](ord: Ord[T]): Ord[Option[T]] = new Ord[Option[T]] {
    override def lt(a: Option[T], b: Option[T]): Boolean = (a, b) match {
      case (Some(a), Some(b)) => ord.lt(a, b)
      case (_, None)          => false
      case (None, _)          => true
    }
  }
}
