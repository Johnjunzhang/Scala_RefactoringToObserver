package refactoringToObserver

import scala.collection.mutable

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  private val observers = mutable.MutableList[IObserver]()
  val seedingMachineObserver = new SeedingMachineObserver(seedingMachine)
  val wateringMachineObserver = new WateringMachineObserver(wateringMachine)
  val reapingMachineObserver = new ReapingMachineObserver(reapingMachine)
  subscribe(seedingMachineObserver)
  subscribe(wateringMachineObserver)
  subscribe(reapingMachineObserver)

  def subscribe(observer: IObserver) = {
    observers += observer
  }

  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    observers.foreach(_.update(temp, humidity, windPower))
  }
}
