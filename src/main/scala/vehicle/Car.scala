package vehicle

import java.util.Date
import normativeReferenceInformation.{CarType, CargoType}

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 15:08
 */
case class Car(carType: CarType, override val repairMileage: Int, override val repairDate: Date)
  extends AbstractVehicle(repairDate, repairMileage) {
  var cargoType: CargoType = null

  def realLength(): Double = carType.length
}