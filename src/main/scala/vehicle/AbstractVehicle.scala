package vehicle

import com.xj.anylogic.libraries.rail.RailCar
import java.util.Date

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 15:06
 */
abstract class AbstractVehicle(val repairDate: Date, val repairMileage: Int) extends RailCar {

}