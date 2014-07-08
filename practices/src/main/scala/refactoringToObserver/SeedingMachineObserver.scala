package refactoringToObserver

class SeedingMachineObserver(seedingMachine:SeedingMachine) extends IObserver {
  def update(temp: Int, humidity: Int, windPower: Int) = {
    if (temp > 5) {
      seedingMachine.start();
    }
  }
}
