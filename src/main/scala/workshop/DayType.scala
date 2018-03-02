package workshop

sealed trait DayType

object DayType {

  case object WeekDay extends DayType

  case object Weekend extends DayType

}
