package station

import normativeReferenceInformation.Station
import com.xj.anylogic.engine.presentation.ShapePolyLine

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 14:46
 */
class SortingTrack(length: Double, number: String, polyline: ShapePolyLine)
  extends AbstractTrack(number, length, polyline) {
  var destination: Station = null

}