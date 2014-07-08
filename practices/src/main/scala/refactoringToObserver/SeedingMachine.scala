package refactoringToObserver

class SeedingMachine() {
  var status = false
  def start():Unit = {
    status = true;
  }
}
