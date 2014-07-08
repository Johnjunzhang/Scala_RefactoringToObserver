package refactoringToObserver

import scala.collection.mutable

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  private val observers = mutable.MutableList[IObserver]()
  subscribe(new SeedingMachineObserver(seedingMachine))
  subscribe(new WateringMachineObserver(wateringMachine))
  subscribe(new ReapingMachineObserver(reapingMachine))

  def subscribe(observer: IObserver) = {
    observers += observer
  }

  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    observers.foreach(_.update(temp, humidity, windPower))
  }
}
