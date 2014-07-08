package refactoringToObserver

class ReapingMachine() {
  var status = false
  def start():Unit = {
    status = true;
  }
}
