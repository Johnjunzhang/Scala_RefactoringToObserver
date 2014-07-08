package refactoringToObserver

class WateringMachine() {
  var status = false
  def start():Unit = {
    status = true;
  }
}
