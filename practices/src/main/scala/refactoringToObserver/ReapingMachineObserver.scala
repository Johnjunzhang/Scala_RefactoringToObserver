package refactoringToObserver

class ReapingMachineObserver(reapingMachine:ReapingMachine) extends IObserver {
  def update(temp: Int, humidity: Int, windPower: Int) {
    if (temp > 5 && humidity > 65)
      reapingMachine.start();
  }
}
