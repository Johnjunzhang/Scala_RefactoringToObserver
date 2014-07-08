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

    it("reaping_machine_should_start_if_temperature_over_5_degree_and_humidity_over_65") {
      val weatherData = getWeatherData
      weatherData.measurementsChanged(10, 70, 0)
      reapingMachine.status should be(true)
    }

    it("water_machine_should_start_if_temperature_over_10_degree_and_humidity_less_than_55_and_wind_power_less_than_4") {
      val weatherData = getWeatherData
      weatherData.measurementsChanged(12, 50, 2)
      wateringMachine.status should be(true)
    }
  }

  def getWeatherData:WeatherData = {
    new WeatherData(seedingMachine, reapingMachine, wateringMachine)
  }
}
