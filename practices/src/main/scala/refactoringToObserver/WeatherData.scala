package refactoringToObserver

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    seedingMachineUpdate(temp, humidity, windPower)
    reapingMachineUpdate(temp, humidity, windPower)
    wateringMachineUpdate(temp, humidity, windPower)
  }

  def wateringMachineUpdate(temp: Int, humidity: Int, windPower: Int) {
    val wateringMachineObserver = new WateringMachineObserver(wateringMachine)
    wateringMachineObserver.update(temp, humidity, windPower)
  }

  def reapingMachineUpdate(temp: Int, humidity: Int, windPower:Int) {
    val reapingMachineObserver = new ReapingMachineObserver(reapingMachine)
    reapingMachineObserver.update(temp, humidity, windPower)
  }

  def seedingMachineUpdate(temp: Int, humidity: Int, windPower:Int) {
    val seedingMachineObserver = new SeedingMachineObserver(seedingMachine)
    seedingMachineObserver.update(temp, humidity, windPower)
  }
}
