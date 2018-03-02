package workshop

sealed trait CustomerType

object CustomerType {
case object Reward extends CustomerType
case object Regular extends CustomerType
}