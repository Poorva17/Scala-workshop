def insert(xs: List[Int], x:Int): List[Int] = {
  xs match {
    case Nil => x :: xs
    case head :: tail =>
      if (x < head) x :: xs
      else head :: insert(tail, x)
  }
}

insert(List(1, 4, 5), 3)
insert(List(1, 4), 0)
insert(List(3, 5), 6)


def insert1(xs: List[Int], x:Int): List[Int] = (xs, x) match {
  case (Nil, x) => x :: List.empty
  case (xs, x) =>
    if(x < xs.head) x :: xs
    else xs.head :: insert1(xs.tail, x)
}

insert1(List(1, 4, 5), 3)
insert1(List(1, 4), 0)
insert1(List(3, 5), 6)



