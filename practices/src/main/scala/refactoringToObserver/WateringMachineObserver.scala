package refactoringToObserver

class WateringMachineObserver(wateringMachine:WateringMachine) extends IObserver {
  def update(temp: Int, humidity: Int, windPower: Int) {
    if (temp > 10 && humidity < 55 && windPower < 4)
      wateringMachine.start();
  }
}
