package refactoringToObserver

import scala.collection.mutable

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  private val observers = mutable.MutableList[IObserver]()

  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    val seedingMachineObserver = new SeedingMachineObserver(seedingMachine)
    val wateringMachineObserver = new WateringMachineObserver(wateringMachine)
    val reapingMachineObserver = new ReapingMachineObserver(reapingMachine)
    observers += seedingMachineObserver
    observers += wateringMachineObserver
    observers += reapingMachineObserver

    observers.foreach(_.update(temp, humidity, windPower))
  }
}
