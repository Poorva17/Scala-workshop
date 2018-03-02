package workshop

import workshop.CustomerType.{Regular, Reward}
import workshop.DayType.{WeekDay, Weekend}

trait Hotel {
  val rating: Int
  def getRate(customerType: CustomerType, days: List[DayType]): Int

  def betterFor(customer: Customer, otherHotel: Hotel): Hotel = {
    val myRate     = this.getRate(customer.customerType, customer.Days)
    val othersRate = otherHotel.getRate(customer.customerType, customer.Days)

    if (myRate == othersRate) {
      if (this.rating > otherHotel.rating) this
      else otherHotel
    } else if (myRate > othersRate) otherHotel
    else this
  }

}

case class LakeWood() extends Hotel {
  override val rating: Int = 3

  override def getRate(customerType: CustomerType, days: List[DayType]): Int = {
    var rate: Int = 0
    days.foreach {
      case WeekDay =>
        customerType match {
          case Reward  => rate += 80
          case Regular => rate += 110
        }
      case Weekend =>
        customerType match {
          case Reward  => rate += 80
          case Regular => rate += 90
        }
    }
    rate
  }
}

case class BridgeWood() extends Hotel {
  override val rating: Int = 4

  override def getRate(customerType: CustomerType, days: List[DayType]): Int = {
    var rate: Int = 0
    days.foreach {
      case WeekDay =>
        customerType match {
          case Reward  => rate += 110
          case Regular => rate += 160
        }
      case Weekend =>
        customerType match {
          case Reward  => rate += 50
          case Regular => rate += 60
        }
    }
    rate
  }
}

case class RidgeWood() extends Hotel {
  override val rating: Int = 5

  override def getRate(customerType: CustomerType, days: List[DayType]): Int = {
    var rate: Int = 0
    days.foreach {
      case WeekDay =>
        customerType match {
          case Reward  => rate += 100
          case Regular => rate += 220
        }
      case Weekend =>
        customerType match {
          case Reward  => rate += 40
          case Regular => rate += 150
        }
    }
    rate
  }
}
