package workshop

import workshop.CustomerType.Reward
import workshop.DayType.{WeekDay, Weekend}

object Main extends App {
  val customer = new Customer(Reward, List(Weekend, WeekDay, WeekDay))

  val lakeWood   = new LakeWood()
  val bridgeWood = new BridgeWood()
  val ridgeWood  = new RidgeWood()

  val lakeWoodRate = lakeWood.getRate(customer.customerType, customer.Days)
  println(lakeWoodRate)

  val bridgeWoodRate = bridgeWood.getRate(customer.customerType, customer.Days)
  println(bridgeWoodRate)

  val ridgeWoodRate = ridgeWood.getRate(customer.customerType, customer.Days)
  println(ridgeWoodRate)

  private val betterHotel: Hotel = lakeWood.betterFor(customer, bridgeWood).betterFor(customer, ridgeWood)
  println(betterHotel)
}
