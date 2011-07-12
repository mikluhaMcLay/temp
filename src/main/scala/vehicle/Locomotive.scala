package vehicle

import java.util.Date
import normativeReferenceInformation.LocomotiveType

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 15:19
 */
case class Locomotive(locoType: LocomotiveType, override val repairMileage: Int, override val repairDate: Date)
  extends AbstractVehicle(repairDate, repairMileage) {

}