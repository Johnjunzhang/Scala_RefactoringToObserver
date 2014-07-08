package refactoringToObserver

abstract class IObserver {
  def update(temp: Int, humidity: Int, windPower: Int)
}