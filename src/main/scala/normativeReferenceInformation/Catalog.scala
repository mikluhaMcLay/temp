package normativeReferenceInformation

import collection.mutable.HashMap

/**
 * Developer: Михаил Бородин
 * Date: 01.07.11
 * Time: 15:03
 */
class Catalog[T] {
  val map = new HashMap[Int, T]


  def addItem(id: Int, item: T) = map += id -> item

  def getItem(id: Int): Option[T] = map get (id)

}