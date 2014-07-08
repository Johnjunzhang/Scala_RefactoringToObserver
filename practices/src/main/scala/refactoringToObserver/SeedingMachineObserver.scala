package refactoringToObserver

class SeedingMachineObserver(seedingMachine:SeedingMachine) {
  def seedingMachineUpdate(temp:Int) = {
    if (temp > 5) {
      seedingMachine.start();
    }
  }
}
