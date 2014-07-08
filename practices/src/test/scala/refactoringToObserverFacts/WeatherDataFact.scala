package movingFeaturesFacts

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, FunSpec}
import refactoringToObserver.{WateringMachine, ReapingMachine, SeedingMachine, WeatherData}

@RunWith(classOf[JUnitRunner])
class WeatherDataFact extends FunSpec with Matchers {
  val seedingMachine = new SeedingMachine()
  val reapingMachine = new ReapingMachine()
  val wateringMachine = new WateringMachine()

  describe("WeatherDataFact") {
    it("seeding_machine_should_start_if_temperature_over_5_degree") {
      val weatherData = getWeatherData
      weatherData.measurementsChanged(10, 0, 0)
      seedingMachine.status should be(true)
    }
  }

  def getWeatherData:WeatherData = {
    new WeatherData(seedingMachine, reapingMachine, wateringMachine)
  }
}
