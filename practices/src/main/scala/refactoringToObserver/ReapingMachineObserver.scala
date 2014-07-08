package refactoringToObserver

class ReapingMachineObserver(reapingMachine:ReapingMachine) {
  def reapingMachineUpdate(temp: Int, humidity: Int) {
    if (temp > 5 && humidity > 65)
      reapingMachine.start();
  }
}
