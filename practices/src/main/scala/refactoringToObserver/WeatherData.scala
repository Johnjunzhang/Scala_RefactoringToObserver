package refactoringToObserver

class WeatherData(seedingMachine: SeedingMachine, reapingMachine: ReapingMachine, wateringMachine: WateringMachine) {
  def measurementsChanged(temp: Int, humidity: Int, windPower: Int):Unit = {
    if (temp > 5) {
      seedingMachine.start();

      if (humidity > 65)
        reapingMachine.start();
    }

    if (temp > 10 && humidity < 55 && windPower < 4)
      wateringMachine.start();
  }
}
