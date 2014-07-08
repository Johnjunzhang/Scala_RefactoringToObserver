package refactoringToObserver

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    seedingMachineUpdate(temp)
    reapingMachineUpdate(temp, humidity)
    wateringMachineUpdate(temp, humidity, windPower)
  }


  def wateringMachineUpdate(temp: Int, humidity: Int, windPower: Int) {
    val wateringMachineObserver = new WateringMachineObserver(wateringMachine)
    wateringMachineObserver.wateringMachineUpdate(temp, humidity, windPower)
  }

  def reapingMachineUpdate(temp: Int, humidity: Int) {
    val reapingMachineObserver = new ReapingMachineObserver(reapingMachine)
    reapingMachineObserver.reapingMachineUpdate(temp, humidity)
  }

  def seedingMachineUpdate(temp: Int) {
    val seedingMachineObserver = new SeedingMachineObserver(seedingMachine)
    seedingMachineObserver.seedingMachineUpdate(temp)
  }
}
