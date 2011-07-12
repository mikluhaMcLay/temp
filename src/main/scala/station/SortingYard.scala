package station

import collection.mutable.HashSet
import com.xj.anylogic.engine.presentation.ShapePolyLine
import normativeReferenceInformation.Station


/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 14:51
 */
class SortingYard(name: String) extends AbstractYard(name) {
  var sortingTracks = new HashSet[SortingTrack]()

  def createTrack(number: String, length: Double, polyline: ShapePolyLine, destination: Station) = {
    val track = new SortingTrack(length, number, polyline)
    track.destination = destination
    sortingTracks add (track)
  }
}