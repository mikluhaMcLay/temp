package station

import collection.mutable.{HashSet, Set}
import com.xj.anylogic.engine.presentation.ShapePolyLine

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 14:28
 */
abstract class AbstractYard(val name: String) {
  val tracks: Set[AbstractTrack] = new HashSet[AbstractTrack]()

  def createTrack(length: Double, number: String, polyline: ShapePolyLine) {
  }

}